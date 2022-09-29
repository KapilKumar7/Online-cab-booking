package com.cabBooking.services;
import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.SignUp;

public interface SignUpService {
	
	public SignUp createNewSignUp(SignUp signUp) throws LoginException;;
	
	public SignUp updateSignUpDetails(SignUp signUp,String key) throws LoginException;;

}
