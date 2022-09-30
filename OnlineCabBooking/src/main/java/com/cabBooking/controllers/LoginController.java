package com.cabBooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.LoginData;
import com.cabBooking.services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody LoginData loginData) throws LoginException {
		return loginService.logInAccount(loginData);
		
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws LoginException
	{
		return loginService.logOutFromAccount(key);
	}
	

}
