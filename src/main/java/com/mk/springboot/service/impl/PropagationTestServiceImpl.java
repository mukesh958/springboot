package com.mk.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mk.springboot.bean.Loan;
import com.mk.springboot.model.LoanRequest;
import com.mk.springboot.repositary.EmployeeRepository;
import com.mk.springboot.service.LoanService;
import com.mk.springboot.service.PropagationTestService;

@Service
public class PropagationTestServiceImpl implements PropagationTestService {

	@Autowired
	LoanService loanService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void processPayment(LoanRequest loanRequest) {
		System.out.println("Processing payment...");
		employeeRepository.save(loanRequest.getEmployee());
        deductAmount(loanRequest.getLoan());
	}

    public void deductAmount(Loan loan) {
        System.out.println("Deducting amount...");
        loanService.saveLoanDetails(loan);
    }
}
