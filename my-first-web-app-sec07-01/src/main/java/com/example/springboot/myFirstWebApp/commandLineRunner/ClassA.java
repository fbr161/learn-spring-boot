package com.example.springboot.myFirstWebApp.commandLineRunner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ClassA {
	public static String names;
	
	static {
		names = "fuad";
//		names = new ArrayList<>();
//		names.add("fuad bin");
	}
}
