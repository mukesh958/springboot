package com.mk.springboot.service;

import org.springframework.stereotype.Service;

import com.mk.springboot.bean.Loan;

@Service
public interface LoanService {
	public void saveLoanDetails(Loan loan);

}
