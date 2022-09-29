package com.cabBooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBooking.entity.Cab;
@Repository
public interface CabDao extends JpaRepository<Cab, Integer> {
	
}
