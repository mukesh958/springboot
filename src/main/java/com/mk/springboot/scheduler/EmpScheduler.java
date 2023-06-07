package com.mk.springboot.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mk.springboot.bean.Employee;
import com.mk.springboot.repositary.EmployeeRepository;

@Service
public class EmpScheduler {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//Scheduler will start in 10 second
	@Scheduled(fixedRate = 10000)
	public void getEmployee() {
		System.out.println("Scheduler called.....");
		List<Employee> empLst= employeeRepository.findAll();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("empLst "+empLst.toString());
	} 

}
