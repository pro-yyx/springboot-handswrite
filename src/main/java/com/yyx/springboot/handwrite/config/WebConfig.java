package com.yyx.springboot.handwrite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 通过注解方式启动springmvc功能
 * @Auther: yinyuxin
 * @Date: 2018/12/29 11:46
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.yyx.springboot.handwrite.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    //配置视图转换器
}
