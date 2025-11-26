package com.mk.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.mk.springboot.service.Notification;

@Service("whatsapp")
public class WhatsAppNotification implements Notification {

	@Override
	public String send(String msg) {
		return "Message send through WhatsApp "+msg;
	}

}