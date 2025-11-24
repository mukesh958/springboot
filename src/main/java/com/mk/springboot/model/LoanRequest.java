package com.mk.springboot.model;

import com.mk.springboot.bean.Employee;
import com.mk.springboot.bean.Loan;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoanRequest {
	Employee employee;
	Loan loan;
}
