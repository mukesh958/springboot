package com.mk.springboot.service;

import com.mk.springboot.model.LoanRequest;

public interface PropagationTestService {
	 public void processPayment(LoanRequest loanRequest);
}
