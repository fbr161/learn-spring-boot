package com.example.learnspringaopsec17.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.learnspringaopsec17.aop.business.BusinessService1;

@Component
public class Runner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private BusinessService1 businessService1; 
	
	public Runner(BusinessService1 businessService1) {
		this.businessService1 = businessService1;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("value returened {}", businessService1.retrieveMax());
		System.out.println("fuad");
	}
}
