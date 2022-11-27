package com.mk.springboot.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mk.springboot.service.DepartmentService;


@Component("hRDepartment")
//@Primary
public class HRDepartment implements DepartmentService {

	@Override
	public String getDepartment() {
		return "HR";
	}

}
