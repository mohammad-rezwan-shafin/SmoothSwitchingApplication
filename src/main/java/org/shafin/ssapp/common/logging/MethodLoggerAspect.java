/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.common.logging;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rezwan
 */
@Aspect
@Component
public class MethodLoggerAspect {
    
    @Around("execution(* org.shafin..*(..)) &&  @annotation(org.shafin.ssapp.common.logging.LogMethodIO)")
    public Object serviceMethodLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        
        Object response = null;
        Logger log = LoggerFactory.getLogger(proceedingJoinPoint.getTarget().getClass());

        log.info(
            "Method Name = {}; Args = {}",
            proceedingJoinPoint.getSignature().getName(),
            ( (proceedingJoinPoint.getArgs() != null ) ? Arrays.toString(proceedingJoinPoint.getArgs()) : ""  )
        );
        try {
            response = proceedingJoinPoint.proceed();
            log.info(
                "Method Name = {}; Response = {}",
                proceedingJoinPoint.getSignature().getName(),
                response
            );
        } catch (Throwable th) {
            log.error("Error ", th);
            throw th;
        }
        return response;
    }
}
