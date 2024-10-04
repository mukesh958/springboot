package com.mk.springboot.dependecyBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BeanB {
	private BeanA beanA;
	public BeanB( @Lazy BeanA beanA) {
		this.beanA = beanA;
	}
}
