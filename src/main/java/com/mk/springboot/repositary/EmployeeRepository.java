package com.mk.springboot.repositary;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.springboot.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public List<Employee> findByJoiningDateBetween(LocalDate joiningStartDate, LocalDate joiningEndDate);
}
