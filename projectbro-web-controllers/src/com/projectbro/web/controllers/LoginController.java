package com.projectbro.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectbro.business.service.LoginService;
import com.projectbro.business.service.TokenService;
import com.projectbro.business.serviceImpl.LoginServiceImpl;
import com.projectbro.business.serviceImpl.TokenServiceImpl;

//@Contoller tells spring this is not a normal claas, its a contoller	
@Controller
//@Component - Tell spring create object for this contoller and put into and register inside spring container
//So I dont have to create, spring will create it.
//activate spring component scanning, spring looks in package declared in xml file so initate controller and put into contatiner
//@Controller does the same thing

//class level mapping
//@RequestMapping("/login")
public class LoginController {
	
	//URL: http://localhost:8080/authenticationService/authenticate/getToken
	
	//@Autowired
	private LoginService loginService = new LoginServiceImpl();
	private TokenService tokenService = new TokenServiceImpl();
	private String token;
	private boolean tokenExpired = false;
	
	@ResponseBody
	//method level mapping
	@RequestMapping("/getToken")
	public String getToken() {
		//create service to generate random token
		//send to user and get them to type in while logging in
		//maybe set time limit and it resets, user needs to get again then!
		
		//Save token in db and read, ideas?
		
		//Need to set up a timer, token expires
		token = tokenService.generateToken();
		//Set timer Time
		return token;
	}
	
	@ResponseBody
	@RequestMapping("/authenticate")
	public String getName(@RequestParam(required = true) String username, String password, String token) {
		return loginService.login(username, "123-abc");
	}
	
	//http://localhost:8080/authenticationService/authenticate/api/foos?id=abc
	@GetMapping("/api/foos")
	@ResponseBody
	public String getFoos(@RequestParam(required = true) String id) {
	    return "ID: " + id;
	}
}
