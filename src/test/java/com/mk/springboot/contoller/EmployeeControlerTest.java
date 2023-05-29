package com.mk.springboot.contoller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mk.springboot.bean.Employee;
import com.mk.springboot.model.EmpRequset;
import com.mk.springboot.repositary.EmpRepository;
import com.mk.springboot.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControlerTest {
	@InjectMocks
	private EmployeeControler employeeControler;

	@Mock
	private EmployeeService employeeService;

	@Mock
	private EmpRepository empRepository;
	
	@Test
	void saveEmployeeTest() {
		Employee emp=getEmployee();
		Mockito.when(employeeService.saveEmployee(Mockito.any())).thenReturn(emp);
		
		EmpRequset request= new EmpRequset();
		request.setName("Mukesh");
		ResponseEntity<String> resposeEntity =employeeControler.saveEmployee(request);
		assertNotNull(resposeEntity);
		assertTrue(StringUtils. containsIgnoreCase(resposeEntity.getBody(), "saved employee with empid"));
		
	}
	Employee getEmployee(){
		Employee emp=new Employee();
		emp.setName("Mukesh");
		return emp;
	}
}
