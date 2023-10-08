package com.mk.springboot.repositary;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.springboot.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public List<Employee> findByJoiningDateBetween(LocalDate joiningStartDate, LocalDate joiningEndDate);
	
	@Transactional
	@Modifying
	@Query(value="delete from employee where name like ?1", nativeQuery = true)
	public int deleteEmployeeByName(String name);
}
