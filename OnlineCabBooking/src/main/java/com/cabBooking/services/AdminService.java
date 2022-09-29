package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminService {
		
	public Admin resgisterAdmin(Admin admin) throws AdminException;

	public Admin update(Admin admin, String Username, String password)  throws AdminException;

	public Admin deleteAdmin(Integer AdminId)  throws AdminException;

	public List<TripBookingService> getAllTrips(Integer customerId) throws TripBookingException;
	
	public List<TripBookingService> getTripsCabwise()  throws TripBookingException;
	
	public List<TripBookingService> getTripsCustomerwise()  throws TripBookingException;
	
	
	public List<TripBookingService> getTripsDatewise()  throws TripBookingException;
	

	public List<TripBookingService> getAllTripsForDays(Integer customerId,LocalDateTime fromDate,LocalDateTime toDate) throws TripBookingException;
	
	
	
}
