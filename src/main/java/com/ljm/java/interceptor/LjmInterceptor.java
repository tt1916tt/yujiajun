package com.ljm.java.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class LjmInterceptor implements HandlerInterceptor {

    private static final  ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal<>();

    private static DateTimeFormatter  FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    @Value("${ljm.config.time-zone}")
    private  String timeZone;



    //  请求方法执行之前  返回true则通过
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从header中获取凭证authToken
        StringBuffer sb = request.getRequestURL();
        long begin = System.currentTimeMillis();
        THREAD_LOCAL.set(begin);
        String time = FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(begin), ZoneId.of(ZoneId.SHORT_IDS.get(timeZone))));
        log.info("preHandler 请求URL {} Content-Type {} method {} at {}", sb.toString(), request.getContentType(), request.getMethod(), time);
        return true;
    }

    // 返回modelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        StringBuffer sb = request.getRequestURL();
        long end = System.currentTimeMillis();
        String time = FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(end), ZoneId.of(ZoneId.SHORT_IDS.get(timeZone))));
        log.info("postHandle 请求URL： {} 返回modelAndView之前 at {} elaspe {} millis", sb.toString(), time,  (end-THREAD_LOCAL.get()) );
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //请求结束释放资源
        StringBuffer sb = request.getRequestURL();
        long end = System.currentTimeMillis();
        String time = FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(end), ZoneId.of(ZoneId.SHORT_IDS.get(timeZone))));
        log.info("afterCompletion  请求URL： {} 执行完请求方法完全返回之后 at {} elaspe {} millis", sb.toString(), time,  (end-THREAD_LOCAL.get()) );
        THREAD_LOCAL.remove();
    }
}
