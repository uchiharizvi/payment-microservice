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
@Component
public class RestLogAspect {

    @Around(value = "@annotation(com.banking.paymentsms.aspects.RestLog)")
    public Object restLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        Instant startTime = Instant.now();
        Object object = joinPoint.proceed();
        Instant endTime = Instant.now();
        log.info("Total Time Taken for Processing {} MS", Duration.between(startTime, endTime).toMillis());
        return object;
    }
}
