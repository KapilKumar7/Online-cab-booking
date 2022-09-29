package com.cabBooking.services;

import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.CurrentUserSession;
import com.cabBooking.models.SignUp;

public interface CurrentUserSessionService {
	
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException;;
	public Integer getCurrentUserSessionId(String key) throws LoginException;;
	
	public SignUp getSignUpDetails(String key) throws LoginException;;
	

}
