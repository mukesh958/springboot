package com.mk.springboot.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mk.springboot.response.ListingResponse;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Configuration
@Slf4j
public class ResponseAspect {
	
	@Around("@annotation(com.mk.springboot.annotation.ConvertPageResponse)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("Aspect called....");
		Object response = joinPoint.proceed();
		ListingResponse<String, Long, Object> listingResponse = new ListingResponse<>();
		Page<?> page = null;
		log.debug("1.0");
		if (response instanceof Page) {
			log.debug("1.1");
			page = (Page<?>) response;
			listingResponse.setData(page.getContent());
			listingResponse.getPageInfo().put("totalRecords", Long.valueOf(page.getTotalElements()));
			listingResponse.getPageInfo().put("totalPages", Long.valueOf(page.getTotalPages()));
			return new ResponseEntity<>(listingResponse, HttpStatus.OK);
		}  
		return response;
	}

}
