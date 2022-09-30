package com.cabBooking.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.models.CurrentUserSession;



public interface CurrentUserSessionDAO extends JpaRepository<CurrentUserSession,Integer> {
	
	public Optional<CurrentUserSession> findByUserId(Integer userId);
	
	public Optional<CurrentUserSession> findByUuid(String uuid);

}
