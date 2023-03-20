package com.example.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CurrencyConfig currencyConfig;

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		
		return Arrays.asList(
				new Course(1L, "Learn Java", "fuad"),
				new Course(2L, "Learn Spring", "bin")
				);
	}
	
	@RequestMapping("/")
	public CurrencyConfig index() {
		return currencyConfig;
	}
}
