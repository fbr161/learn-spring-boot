package com.example.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("hello-world/{name}")
	public String helloWorld(@PathVariable String name) {
		return name+ " hello there";
	}
	
	@GetMapping("hello-world/laguage")
	public String helloWorldLanguage() {
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("language.code", null, "defualt lng", locale);
	}
}
