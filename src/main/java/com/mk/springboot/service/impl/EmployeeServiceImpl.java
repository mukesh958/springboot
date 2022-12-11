package com.mk.springboot.service.impl;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

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
	@Override
	public Employee updateEmployee(Integer id, EmpRequset emp) {
		Employee e= employeeRepository.findById(id).get();
		e.setName(emp.getName());
		e.setSalary(emp.getSalary());
		e=employeeRepository.save(e);
		return e;
	}
	@Override
	public Employee updateEmployeeByField(Integer id, Map<String, Object> fields) {
		Optional<Employee> existingEmp= employeeRepository.findById(id);
		if(existingEmp.isPresent()) {
			fields.forEach((key,value)->{
				Field field=ReflectionUtils.findField(Employee.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingEmp.get(), value);
			});
			return employeeRepository.save(existingEmp.get());
		}
		return null;
	}
}
