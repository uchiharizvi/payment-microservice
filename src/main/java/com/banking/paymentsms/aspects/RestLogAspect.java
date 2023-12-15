package com.banking.paymentsms.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
public class RestLogAspect {

    @Around(value = "@annotation(restLogAnnotation)")
    public Object restLog(ProceedingJoinPoint joinPoint, RestLog restLogAnnotation) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String apiName = restLogAnnotation.apiName();
        Instant startTime = Instant.now();
        Object object = joinPoint.proceed();
        Instant endTime = Instant.now();
        log.info("Total Time Taken for Processing {} in Milliseconds {}", apiName, Duration.between(startTime, endTime).toMillis());
        return object;
    }
}
