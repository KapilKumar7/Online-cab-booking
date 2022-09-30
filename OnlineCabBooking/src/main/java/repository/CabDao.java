package com.cabBooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.Cab;

public interface CabDao extends JpaRepository<Cab, Integer> {

	List<Cab> findAllByCabtype(String cabType);
	
}
