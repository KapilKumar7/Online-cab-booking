package com.cabBooking.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.TripBooking;

@Repository
public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{
		
	
	@Query("select t from TripBooking t where t.customer = (select c from Customer c where c.customerId=?1)")
	public List<TripBooking> getAllTripsByCustomerId(int customerId);
	
	@Query("select t from TripBooking t where t.status=1 and t.customer = (select c from Customer c where c.customerId=?1)")
	public TripBooking getCurrentTripByCustomerId(int customerId);
	
//	@Query("select t from TipBooking t  order By t. ASC  ")
//	public List<TripBooking> getAllTripCabwise();    
	
	
	
	
	@Query("select t from TripBooking t where t.fromDateTime=?2 and t.toDateTime=?3 and t.customer = (select c from Customer c where c.customerId=?1)")
	public List<TripBooking> getAllTripBetweenDate(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate);
}