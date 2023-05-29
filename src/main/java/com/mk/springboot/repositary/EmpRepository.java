package com.mk.springboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mk.springboot.bean.Emp;

public interface EmpRepository extends JpaRepository<Emp, Emp>{

}
