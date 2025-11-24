package com.mk.springboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springboot.model.LoanRequest;
import com.mk.springboot.service.PropagationTestService;


@RestController
@RequestMapping("/propagation")
public class PropagationTestController {
	
	@Autowired
	private PropagationTestService propagationTestService;
	
	@PostMapping("/processPayment")
	public ResponseEntity<?> process(@RequestBody LoanRequest loanRequest) {
		propagationTestService.processPayment(loanRequest);
		return ResponseEntity.ok("Payment processed successfully");
	}
}
