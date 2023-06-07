package com.mk.springboot;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class SpringbootApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
