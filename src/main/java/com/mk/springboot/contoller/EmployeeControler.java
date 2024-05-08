package com.mk.springboot.contoller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springboot.annotation.ConvertPageResponse;
import com.mk.springboot.bean.Emp;
import com.mk.springboot.bean.Employee;
import com.mk.springboot.model.EmpRequset;
import com.mk.springboot.repositary.EmpRepository;
import com.mk.springboot.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/rest/employee")
@Slf4j
public class EmployeeControler {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmpRepository empRepository;
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmpRequset request){
		Employee emp= employeeService.saveEmployee(request);
		log.info("Mukesh saved employee with empid {} ",emp.getId());
		return new ResponseEntity<>("saved employee with empid "+ emp.getId(),HttpStatus.OK);
	} 
	@GetMapping
	//@LogPerformanceData
	@ConvertPageResponse
	public Object getEmployee(@PageableDefault(size = 10,sort = "name",direction = Sort.Direction.ASC)Pageable pageable){
		return employeeService.getAllEmployee(pageable);
	} 
	
	@GetMapping("allEmployee")
	public ResponseEntity<List<Emp>> getEmployee(){
		log.info(" getEmployee Called");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(empRepository.findAll(),HttpStatus.OK) ;
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id){
		log.info("getEmployeeById Called...");
		return new ResponseEntity<>(employeeService.finById(id),HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Integer id,@RequestBody EmpRequset request){
		return new ResponseEntity<>(employeeService.updateEmployee(id, request),HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Integer id,@RequestBody Map<String, Object> fields){
		return new ResponseEntity<>(employeeService.updateEmployeeByField(id, fields),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
		log.info("deleteEmployee Called...");
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(id+ " Deleted Successfully.",HttpStatus.OK);
	}
	
	@PostMapping("/savedEmp")
	public ResponseEntity<?> saveEmp(@Valid @RequestBody EmpRequset request){
		Emp e= new Emp();
		e.setName(request.getName());
		e.setRange(request.getJoiningDate());
		e=empRepository.save(e);
		log.info("Emp object saved.");
		return new ResponseEntity<>("Emp object saved.",HttpStatus.OK);
	} 
	@DeleteMapping("/deletebyname/{name}")
	public ResponseEntity<?> deleteEmployeeByName(@PathVariable String name){
		log.info("deleteEmployeeByName Called...");
		int noOfRecordDeleted=employeeService.deleteEmployeeByName(name);
		
		return new ResponseEntity<>(noOfRecordDeleted+ " reord deleted.",HttpStatus.OK);
	}
	
}
