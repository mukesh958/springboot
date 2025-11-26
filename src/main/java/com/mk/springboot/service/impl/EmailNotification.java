package com.mk.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.mk.springboot.service.Notification;

@Service("email")
public class EmailNotification implements Notification {

	@Override
	public String send(String msg) {
		return "Message send through email "+msg;
	}

}