package com.mk.springboot.feign.api.client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mk.springboot.feign.api.model.UserResponse;

@Service

public class EmployeeClient {
	@Autowired
	RestTemplate restTemplate;
	@Async
	public CompletableFuture<List<UserResponse>> employeeCount() {
		
		List<UserResponse>res=(List<UserResponse>) restTemplate.getForObject("https://jsonplaceholder.typicode.com/users",
				Object.class);
		
		return CompletableFuture.completedFuture(res);
	}
}
