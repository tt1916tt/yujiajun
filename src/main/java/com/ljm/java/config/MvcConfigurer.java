package com.ljm.java.config;

import com.ljm.java.interceptor.LjmInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(MvcConfigurer.class);

    @Autowired
    LjmInterceptor ljmInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("add intercepotr ");
        registry.addInterceptor(ljmInterceptor)
                .addPathPatterns("/**")
                // swagger-ui
                .excludePathPatterns(
                        "/",
                        "/csrf",
                        "/v2/api-docs")
        ;
    }
}
