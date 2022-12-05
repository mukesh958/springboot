package com.mk.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mk.springboot.bean.Employee;
import com.mk.springboot.model.EmpRequset;
import com.mk.springboot.repositary.EmployeeRepository;
import com.mk.springboot.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(EmpRequset emp) {
		Employee e= new Employee();
		e.setName(emp.getName());
		e.setSalary(emp.getSalary());
		Employee empr=employeeRepository.save(e);
		return empr;
	}
	@Override
	public Page<Employee> getAllEmployee(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}
	@Override
	public Employee finById(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}
	@Override
	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
	}
}
