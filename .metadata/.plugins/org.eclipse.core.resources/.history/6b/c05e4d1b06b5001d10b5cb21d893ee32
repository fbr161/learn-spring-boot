package com.example.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	// http://localhost:3000 to 8080 
	// is called 'Cross Origin Request'
	
	// Allow only request from http://localhost:3000
	
	@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")  // Enable cross-origin request handling for the specified path pattern.
				.allowedMethods("*")		// Set the HTTP methods to allow, e.g. "GET", "POST", etc.
				.allowedOrigins("http://localhost:3000");//Set the origins for which cross-origin requests are allowed from a browser
			}
		};
	}

}
