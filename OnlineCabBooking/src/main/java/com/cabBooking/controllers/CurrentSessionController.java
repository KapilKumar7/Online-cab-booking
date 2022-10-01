package com.cabBooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.CurrentUserSession;
import com.cabBooking.models.SignUp;
import com.cabBooking.services.CurrentUserSessionService;
@RestController
public class CurrentSessionController {

	@Autowired
	 public CurrentUserSessionService currentUser;
	
	
	@GetMapping("/currentusersession/{key}")
	public ResponseEntity<CurrentUserSession> getCurrentUserSessionHandler(@PathVariable("key") String key) throws LoginException{
		
		CurrentUserSession activeUser=currentUser.getCurrentUserSession(key);
		return new ResponseEntity<CurrentUserSession>(activeUser,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/currentusersessionid/{key}")
	public ResponseEntity<Integer> getCurrentUserIdSessionHandler(@PathVariable("key") String key) throws LoginException{
		
		Integer activeUserId=currentUser.getCurrentUserSessionId(key);
		return new ResponseEntity<Integer>(activeUserId,HttpStatus.OK);
		
	}
	
	@GetMapping("/signup/{key}")
	public ResponseEntity<SignUp> signUpHandler(@PathVariable("key") String key) throws LoginException{
		
	  SignUp signUpUser=currentUser.getSignUpDetails(key);
		return new ResponseEntity<SignUp>(signUpUser,HttpStatus.OK);
		
	}
	
	
	
}