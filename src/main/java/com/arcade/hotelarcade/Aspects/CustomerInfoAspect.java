package com.arcade.hotelarcade.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component  // Don't forget this! Otherwise, Spring won't detect the aspect
@Slf4j
public class CustomerInfoAspect {

    /**
     * Pointcut matching all method executions in {@link com.arcade.hotelarcade.controller.CustomerInfoController}.
     */
    @Pointcut("execution(* com.arcade.hotelarcade.controller.CustomerInfoController.*(..))")
    public void controllerMethods() {
    }


    // Logs the method calls
    @Before("controllerMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Entering method: {} with arguments: {}", methodName, Arrays.toString(args));
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        log.info("Method {} executed successfully, return: {}", methodName, result);
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().toShortString();
        log.error("Method {} executed failure, error: {}", methodName, e.getMessage());
    }
}