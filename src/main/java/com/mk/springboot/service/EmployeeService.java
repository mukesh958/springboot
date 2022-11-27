package com.mk.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mk.springboot.bean.Employee;
import com.mk.springboot.model.EmpRequset;

@Service
public interface EmployeeService {
	public Employee saveEmployee(EmpRequset emp);
	public List<Employee> getAllEmployee();
	public Employee finById(Integer id);
	public void deleteEmployeeById(Integer id);
}
