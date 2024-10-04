package com.mk.springboot.dependecyBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
	private BeanB beanB;

	/*
	 * public BeanA(BeanB beanB) { this.beanB = beanB; }
	 */
	

	
}
