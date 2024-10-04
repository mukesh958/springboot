package com.mk.springboot.dependecyBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Conductor {
	@Autowired
	private ApplicationContext applicationContext;
	private Ticket ticket;
	
	public Ticket getTicket() {
		return applicationContext.getBean(Ticket.class);
	}
	/*
	 * @Lookup
	 *  public Ticket getTicket(){
	 *    return null;
	 *  }
	 */
	/*
	 * @Autowired public void setTicket(Ticket ticket) { this.ticket = ticket; }
	 */
}
