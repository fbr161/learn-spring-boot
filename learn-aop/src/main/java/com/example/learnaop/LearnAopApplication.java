package com.example.learnaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.learnaop.data.DataService;

@SpringBootApplication
public class LearnAopApplication {
	
	@Autowired
	DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(LearnAopApplication.class, args);
	}

}
