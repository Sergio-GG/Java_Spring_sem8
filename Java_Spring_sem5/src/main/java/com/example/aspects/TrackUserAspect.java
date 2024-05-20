package com.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TrackUserAspect {
    @Around(value = "@annotation(TrackUserAction)")
    public void track(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("BEFORE");
        Object obj = joinPoint.proceed();
        System.out.println("Method invoked - " + joinPoint.getSignature().getName());
        System.out.println("AFTER");
    }
}
