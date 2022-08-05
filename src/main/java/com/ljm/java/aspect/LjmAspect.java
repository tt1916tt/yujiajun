package com.ljm.java.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

/**
 * 记录新增公司员工和改变部门或考评人记录
 * */
@Aspect
@Component
public class LjmAspect {
    private static final Logger logger = LoggerFactory.getLogger(LjmAspect.class);


    /*
     * 声明一个切入点,并编写切入点表达式
     *  xxx包路径
     */
    @Pointcut("@annotation(com.ljm.java.annotation.Ljm)")
    public void pointcut(){
    }

    /**
     * 前置通知,指定切入点函数
     * 也可在注解中自定义不同的切入点表达式
     * @Before("execution(...)")
     *
     */
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知..."+joinPoint.getArgs());
    }

    /**
     * 后置通知
     */
    @AfterReturning(value = "pointcut()", returning = "returnVal")
    public void afterReturn(String returnVal){
        System.out.println("后置通知..." + returnVal);

    }

    /**
     * 环绕通知
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知前...");
        Object returnVal = pjp.proceed();
        returnVal = returnVal + "bbbbbbbbbbbb";
        System.out.println("环绕通知后...");
        return returnVal;
    }

    /**
     * 异常通知
     * 通过pointcut指定切入点
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void throwableAdvice(Throwable e){
        System.out.println("异常通知..." + e.getMessage());
    }

    /**
     * 最终通知
     */
    @After("pointcut()")
    public void after(){
        System.out.println("最终通知...");
    }


}
