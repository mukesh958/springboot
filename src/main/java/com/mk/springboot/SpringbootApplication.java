package com.mk.springboot;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableCaching
//@EnableDiscoveryClient
public class SpringbootApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	

	
}