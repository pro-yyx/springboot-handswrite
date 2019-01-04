package com.yyx.springboot.handwrite.config;

import com.yyx.springboot.handwrite.service.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @Description: java操作tomcat
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/12/27 15:36
 */
public class TomcatUtil {

    private static final Integer PORT = 8080;

    /**
     * 根路径
     */
    private static final String CONTEXT_PATH = "/springboot-handswrite";

    private static final String SERVLET_NAME = "index";

    public static void createTomcat() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        //设置端口
        tomcat.setPort(PORT);
        //关闭自动部署
        tomcat.getHost().setAutoDeploy(false);
        //创建上下文  上下文即项目名称
        StandardContext standardContext = new StandardContext();
        standardContext.setPath(CONTEXT_PATH);
        //添加监听器
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        //tomcat 添加standard
        tomcat.getHost().addChild(standardContext);
        //创建servlet
        tomcat.addServlet(CONTEXT_PATH, SERVLET_NAME, new IndexServlet());
        //servlet url映射
        standardContext.addServletMappingDecoded("/index",SERVLET_NAME);
        tomcat.start();
        System.out.println("----------tomcat启动成功了--------");
        tomcat.getServer().await();
    }

    public static void main(String[] args) {
        try {
            createTomcat();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
