package com.example.springboot.myFirstWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private LoginAuthentication loginAuthentication;

	@RequestMapping("hello")
	public String hello(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		
		logger.debug("this is custom info log on LoginController");
		return "sayHello";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String doLoginGet() {

		return "login/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String authorizeLogin(@RequestParam String name, @RequestParam String pass, ModelMap model) {
		if (loginAuthentication.isAuthorized(name, pass)) {
			model.put("name", name);
			return "login/welcome";
		}
		return "login/login";
	}
}
