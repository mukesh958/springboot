package com.mk.springboot.bean;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer salary;
	
	@Column(name = "joining_date")
	private LocalDateTime joiningDate;
	
	@Column(name = "admission_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime admissionDate;

}
