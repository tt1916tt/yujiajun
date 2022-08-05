//package com.ljm.java.config;
//
//import com.ljm.java.filter.LjmFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean registFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new LjmFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("LjmFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//}
