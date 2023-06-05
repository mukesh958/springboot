package com.mk.springboot.contoller;

import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springboot.bean.Employee;
import com.mk.springboot.repositary.EmpRepository;
import com.mk.springboot.service.EmployeeService;
import com.mk.springboot.utility.DateUtlity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/v1/swagger")
public class SwaggerTestController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmpRepository empRepository;
	
	      @Operation(summary = "Retrieve a Employee in date range",description = "Filtering list of employee on the basis of input date range.")
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Employee.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
		  
	@GetMapping("/{joiningStartDate}/{joiningEndDate}")
	public ResponseEntity<?> getEmployeeBetweenTheJoiningDate(
			@Parameter(name = "Joining Start Date", example = "yyyy-mm-dd hh:MM:ss", description = "(yyyy-mm-dd hh:MM:ss)", required = true)
				@PathVariable String joiningStartDate,
			@Parameter(name =  "Joining End Date",example = "yyyy-mm-dd hh:MM:ss",description = "(yyyy-mm-dd hh:MM:ss)",required = true)	
				@PathVariable String joiningEndDate) throws ParseException{
		log.info("getEmployeeById Called...");
		LocalDate joiningStartDate1=DateUtlity.convertStringToLocalDate(joiningStartDate);  
		LocalDate joiningEndDate2=DateUtlity.convertStringToLocalDate(joiningEndDate);
		
		
		return new ResponseEntity<>(employeeService.getEmployeeBetweenTheJoiningDate(joiningStartDate1,joiningEndDate2),HttpStatus.OK);
	}
	
}
