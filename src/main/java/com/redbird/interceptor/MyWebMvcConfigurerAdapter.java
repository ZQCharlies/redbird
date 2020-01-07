package com.redbird.interceptor;

import com.redbird.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 已停用
 */
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;
    /*
    添加自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }

    /*
    配置静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
