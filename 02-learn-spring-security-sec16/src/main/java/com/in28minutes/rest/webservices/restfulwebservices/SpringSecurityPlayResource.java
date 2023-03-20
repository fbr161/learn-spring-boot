package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {

	@GetMapping("/csrf-token")
	CsrfToken retrieveCsrfToken(HttpServletRequest request) {
		
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
