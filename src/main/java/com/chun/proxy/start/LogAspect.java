package com.chun.proxy.start;

/**
 * Author: lixianchun
 * Date: 2018/9/9
 * Description:
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.reflect.Method;

@Aspect
@Order(1)
@Component
@ConditionalOnProperty(
        prefix = "vphonor.web",
        name = {"logProviderEnabled"},
        havingValue = "true",
        matchIfMissing = true
)
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    private static final int RESPONSE_SAVE_MAX_LENGTH = 1000;
    private static final long SLOW_REQUEST_TIME_THRESHOLD = 2000L;
    private ThreadLocal aspectLogThreadLocal = new ThreadLocal();

    public LogAspect() {
        aspectLogThreadLocal.remove();
    }

    @Pointcut("execution( * com..control.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        log.debug("日志前置:");
    }

    @AfterReturning(
            returning = "ret",
            pointcut = "webLog()"
    )
    public void doAfterReturning(Object ret) {
        log.debug("日志后置:{}",ret);
    }

    @AfterThrowing(
            throwing = "ex",
            pointcut = "webLog()"
    )
    public void doAfterThrowing(Throwable ex) {
        log.debug("抛出异常：{}",ex);
    }





}

