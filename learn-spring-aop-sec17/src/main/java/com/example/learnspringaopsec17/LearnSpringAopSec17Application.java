package com.example.learnspringaopsec17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.learnspringaopsec17.aop.Abc;
import com.example.learnspringaopsec17.aop.business.BusinessService1;
import com.example.learnspringaopsec17.aop.data.DataService1;


@SpringBootApplication
public class LearnSpringAopSec17Application {
	
	@Autowired
	private Abc businessService1; 
	
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopSec17Application.class, args);
	}	

}
