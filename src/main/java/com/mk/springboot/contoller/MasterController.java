package com.mk.springboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class MasterController {

	@Autowired
	@Qualifier("hRDepartment")
	DepartmentService departmentService;
	
	@GetMapping("/test")
	public ResponseEntity<?> test(){
		log.info("Department Name :: "+departmentService.getDepartment());
		return new ResponseEntity<>("Test Call",HttpStatus.OK);
	} 
}
