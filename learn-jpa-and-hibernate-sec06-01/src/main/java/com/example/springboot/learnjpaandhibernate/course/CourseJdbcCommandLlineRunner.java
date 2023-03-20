package com.example.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.example.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLlineRunner implements CommandLineRunner {

//	@Autowired
//	CourseJdbcRepository courseRep;
	
//	@Autowired
//	CourseJpaRepository courseRep;
	
	@Autowired
	CourseSpringDataJpaRepository courseRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		courseRep.save(new Course(1L, "Learn Spring", "Fuad"));
		courseRep.save(new Course(2L, "Learn Spring Boot", "Bin"));
		courseRep.save(new Course(3L, "Learn Spring Cloud", "Rahman"));
		
		courseRep.deleteById(2L);
		
		System.out.println(courseRep.findById(1L));
		
	}

}
