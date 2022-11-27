package com.mk.springboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.springboot.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
