package com.mk.springboot.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mk.springboot.bean.Employee;
import com.mk.springboot.model.EmpRequset;

@Service
public interface EmployeeService {
	public Employee saveEmployee(EmpRequset emp);
	public Page<Employee> getAllEmployee(Pageable pageable);
	public Employee finById(Integer id);
	public void deleteEmployeeById(Integer id);
	public int deleteEmployeeByName(String name);
	
	public Employee updateEmployee(Integer d,EmpRequset emp);
	public Employee updateEmployeeByField(Integer d,Map<String, Object> map);
	
	public List<Employee> getEmployeeBetweenTheJoiningDate( LocalDate joiningStartDate, LocalDate joiningEndDate);

}
