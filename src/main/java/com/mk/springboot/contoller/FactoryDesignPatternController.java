package com.mk.springboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springboot.service.Notification;
import com.mk.springboot.utility.NotificationFactory;

@RestController
@RequestMapping("/v1/api")
public class FactoryDesignPatternController {
	
	@Autowired
	NotificationFactory notificationFactory; 
	
	@GetMapping("/send/msg/{type}")
	public ResponseEntity<String> sendNotification(@PathVariable String type){
		Notification notification=notificationFactory.getNotification(type);
		String msg=notification.send(", happy.");
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
