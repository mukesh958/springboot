package com.mk.springboot.dependecyBean;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ticket {
	public static final AtomicInteger increamentCount= new AtomicInteger(0);
	public Ticket() {
		increamentCount.incrementAndGet();
	}
	public void getTicket(){
		System.out.println("Ticket Number "+increamentCount);
		System.out.println("Bean HasCode "+this.hashCode());
	}
}
