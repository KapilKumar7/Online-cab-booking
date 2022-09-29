package com.cabBooking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.CurrentUserSession;
import com.cabBooking.models.SignUp;
import com.cabBooking.repository.CurrentUserSessionDAO;
import com.cabBooking.repository.SignUpDAO;

@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService {

	@Autowired
	private CurrentUserSessionDAO currentUserSessionDAO;
	
	@Autowired
	private SignUpDAO signUpDAO;
	
	@Override
	public CurrentUserSession getCurrentUserSession(String key) {
		
		Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			throw new LoginException("UnAuthorized!!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getCurrentUserSessionId(String key) {
		
		Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			throw new LoginException("UnAuthorized!!!");
		}
		return currentUser.get().getId();
		
	}


	@Override
	public SignUp getSignUpDetails(String key) {
		
		Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signUpDAO.findById(SignUpUserId)).get();
	}

}
