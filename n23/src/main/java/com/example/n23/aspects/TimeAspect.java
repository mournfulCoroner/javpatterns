package com.example.n23.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
    @Pointcut("execution(* com.example.n23.services.*.*(..))")
    public void callAtAllServiceMethods(){}

    @Around("callAtAllServiceMethods()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeStart = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long timeWork = System.currentTimeMillis() - timeStart;

        return proceed;
    }
}
