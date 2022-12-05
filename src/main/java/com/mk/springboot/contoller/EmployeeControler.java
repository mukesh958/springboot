package com.mk.springboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springboot.annotation.ConvertPageResponse;
import com.mk.springboot.annotation.LogPerformanceData;
import com.mk.springboot.bean.Employee;
import com.mk.springboot.model.EmpRequset;
import com.mk.springboot.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/rest/employee")
@Slf4j
public class EmployeeControler {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@Validated @RequestBody EmpRequset request){
		Employee emp= employeeService.saveEmployee(request);
		log.info("saved employee with empid {} ",emp.getId());
		return new ResponseEntity<>("saved employee with empid "+ emp.getId(),HttpStatus.OK);
	} 
	@GetMapping
	//@LogPerformanceData
	@ConvertPageResponse
	public Object getEmployee(@PageableDefault(size = 10,sort = "name",direction = Sort.Direction.ASC)Pageable pageable){
		return employeeService.getAllEmployee(pageable);
	} 
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id){
		log.info("getEmployeeById Called...");
		return new ResponseEntity<>(employeeService.finById(id),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody EmpRequset request){
		log.info("updateEmployee Called...");
		return new ResponseEntity<>("updateEmployee",HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
		log.info("deleteEmployee Called...");
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(id+ " Deleted Successfully.",HttpStatus.OK);
	}
}
