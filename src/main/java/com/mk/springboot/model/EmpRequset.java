package com.mk.springboot.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmpRequset {
	
	@NotBlank(message = "name can not be blank")
	String name;
	
	@JsonProperty("emp_salary")
	Integer salary;
}
