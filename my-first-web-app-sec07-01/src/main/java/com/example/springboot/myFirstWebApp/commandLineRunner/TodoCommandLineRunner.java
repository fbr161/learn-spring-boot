package com.example.springboot.myFirstWebApp.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		ClassA a = new ClassA();
		ClassA b = new ClassA();
		a.names = "abc";
		System.out.println(b.names);
		
	}

}
