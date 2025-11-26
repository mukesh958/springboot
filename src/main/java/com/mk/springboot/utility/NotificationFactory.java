package com.mk.springboot.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mk.springboot.service.Notification;
import com.mk.springboot.service.impl.EmailNotification;
import com.mk.springboot.service.impl.SmsNotification;
import com.mk.springboot.service.impl.WhatsAppNotification;

@Component
public class NotificationFactory {
	
	private final Map<String, Notification> notifications;
	public NotificationFactory(Map<String, Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification getNotification(String type) {
		/*Notification notification = null;
		switch (type) {
		case "sms":
			notification = new SmsNotification();
			break;
		case "email":
			notification = new EmailNotification();
			break;
		case "whatsapp":
			notification = new WhatsAppNotification();
			break;
		default:
			break;
		}*/
		return notifications.get(type);
	}
}
