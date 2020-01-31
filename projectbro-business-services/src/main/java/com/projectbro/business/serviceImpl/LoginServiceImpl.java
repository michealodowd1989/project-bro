package com.projectbro.business.serviceImpl;

import com.projectbro.business.service.LoginService;

//@Service
public class LoginServiceImpl implements LoginService{

	public String login(String username, String password) {
		System.out.print(System.currentTimeMillis() + " - Sucessful login: " + username);
		return System.currentTimeMillis() + " - Sucessful login: " + username;
	}
}
