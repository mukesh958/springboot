package com.mk.springboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springboot.dependecyBean.Conductor;
import com.mk.springboot.dependecyBean.Ticket;

@RestController
@RequestMapping("api/v1/singletoprototype")
public class SingleToPrototypeTestController {

	@Autowired
	private Conductor conductor;
	
	@GetMapping("/getticket")
	public ResponseEntity<String> testSingleToPrototype() {
		Ticket ticket = conductor.getTicket();
		ticket.getTicket();
		return ResponseEntity.ok("Single to Prototype Bean Test");
	}
}
