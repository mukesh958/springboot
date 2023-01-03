package com.mk.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mk.springboot.feign.api.client.UserClient;
import com.mk.springboot.feign.api.model.UserResponse;

@RestController
@RequestMapping("v1/rest/feign")
public class FeignClientTestController {

	@Autowired
	private UserClient userClient;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/users")
	public List<UserResponse> getAllDummyUser() {
		return userClient.getAllUser();
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/usersRestClient")
	public List<UserResponse> getAllDummyUserRestClient() {
		return (List<UserResponse>) restTemplate.getForObject("https://jsonplaceholder.typicode.com/users",
				Object.class);
	}
}
