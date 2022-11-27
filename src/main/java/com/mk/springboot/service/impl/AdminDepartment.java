package com.mk.springboot.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mk.springboot.service.DepartmentService;
@Component("adminDepartment")
@Primary
public class AdminDepartment implements DepartmentService{

	@Override
	public String getDepartment() {
		// TODO Auto-generated method stub
		return "Admin";
	}

}
