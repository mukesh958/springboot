package com.mk.springboot.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceAspect {

	
	private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);
	
    @Around("@annotation(com.mk.springboot.annotation.LogPerformanceData)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    	logger.info("Before Executing the method from PerformanceAspect ------>"+joinPoint.getSignature());
        final long start = System.currentTimeMillis();

        final Object proceed = joinPoint.proceed();

        final long executionTime = System.currentTimeMillis() - start;

        logger.info("After Executing the method from PerformanceAspect ------>"+joinPoint.getSignature());
        logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

}