package com.yyx.springboot.handwrite.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/12/29 11:27
 */
public class SpringApplicationUtil extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * 加载根配置信息
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * springmvc加载配置信息
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringApplicationUtil.class};
    }

    /**
     * springmvc 拦截url映射 拦截所有请求
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
