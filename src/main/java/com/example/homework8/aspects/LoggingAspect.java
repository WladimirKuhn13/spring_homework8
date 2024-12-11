package com.example.homework8.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());


    @Around("execution(* com.example.homework8.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();

        logger.log(INFO, "Начало выполнения метода: " + methodName);
        Object returnedByMethod = joinPoint.proceed();
        logger.info("Окончание выполнения метода: " + methodName);
        return returnedByMethod;
    }
}
