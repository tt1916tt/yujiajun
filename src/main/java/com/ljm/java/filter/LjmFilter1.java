//package com.ljm.java.filter;
//
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/*", filterName = "LjmFilter1")
//public class LjmFilter1 implements Filter {
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        long start = System.currentTimeMillis();
//        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("过滤器2");
//        System.out.println("Execute cost="+(System.currentTimeMillis()-start));
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
