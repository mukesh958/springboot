package com.mk.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mk.springboot.bean.Loan;
import com.mk.springboot.repositary.LoanRepository;
import com.mk.springboot.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	LoanRepository loanRepository;
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void saveLoanDetails(Loan loan) {
		loanRepository.save(loan);
	}

}
