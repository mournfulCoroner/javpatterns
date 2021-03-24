package com.example.n18.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TimeAspect {
    @Pointcut("execution( * com.example.n18.services.*(..))")
    public void callAtAllServiceMethods(){}

    @Before("callAtAllServiceMethods()")
    public void beforeMethod(JoinPoint point){
        log.info("BEGINNNNN");
    }
    @After("callAtAllServiceMethods()")
    public void afterMethod(JoinPoint point){
        log.info("ENDDDDDDDDDDD");
    }
    @Around("callAtAllServiceMethods()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeStart = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long timeWork = System.currentTimeMillis() - timeStart;

        log.info(joinPoint.getSignature() + " time work is " + timeWork + "ms");

        return proceed;
    }
}
