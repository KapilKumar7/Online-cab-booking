package com.cabBooking.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.TripBooking;

@Repository
public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{
		
	
	
	@Query("select t from TripBooking t where t.customer.getCustomerId =?1")
	public List<TripBooking> getAllTripsByCustomerId(int customerId);
	
	@Query("select t from TripBooking t where t.customer.getCustomerId =?1 &t.status=1")
	public TripBooking getCurrentTripByCustomerId(int customerId);
	
//	@Query("from TipBooking ")
//	public List<TripBooking> getAllTripCabwise();    
	
	@Query("select t from TripBooking t where t.customer.getCustomerId= ?1 and t.fromDateTime=?2 and t.toDateTime=?3")
	public List<TripBooking> getAllTripBetweenDate(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate);

}
