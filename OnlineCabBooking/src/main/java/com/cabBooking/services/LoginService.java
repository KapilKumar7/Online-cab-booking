package com.cabBooking.services;

import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.LoginData;

public interface LoginService {
	
	public String logInAccount(LoginData loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;

}
