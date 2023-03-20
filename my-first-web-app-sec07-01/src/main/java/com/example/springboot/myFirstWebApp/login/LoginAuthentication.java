package com.example.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthentication {

	boolean isAuthorized(String name, String password) {
		return name.equals("fuad") && password.equals("1234");
	}
}
