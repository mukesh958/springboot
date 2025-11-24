package com.mk.springboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springboot.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/rest")
@Slf4j
public class QualifierTestController {

	@Value("${test.name}")
	private String name;
	
	@Autowired
	//@Qualifier("hRDepartment")
	private DepartmentService departmentService;
	
	
	@GetMapping("/test")
	public ResponseEntity<?> test(){
		System.out.println("Test Name :: "+name);
		String departmentName=departmentService.getDepartment();
		log.info("Department Name :: "+departmentService.getDepartment());
		return new ResponseEntity<>("departmentName"+departmentName,HttpStatus.OK);
	} 
}
