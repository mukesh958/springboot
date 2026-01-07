package com.mk.springboot.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	@Bean
	@LoadBalanced
	@Lazy
	public RestTemplate getRestTemplate() {
		/*HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);// Connection timeout (ms)
		clientHttpRequestFactory.setReadTimeout(3000);// read timeout (ms)
		clientHttpRequestFactory.setConnectionRequestTimeout(3000); // Timeout for getting a connection from pool
		return new RestTemplate(clientHttpRequestFactory);*/
		return new RestTemplate();
	}
}
