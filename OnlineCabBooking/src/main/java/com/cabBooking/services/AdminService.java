package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminService {
		
	public Admin resgisterAdmin(Admin admin) throws AdminException;

	public Admin update(Admin admin, String Username, String password)  throws AdminException;

	public Admin deleteAdmin(Integer Admin)  throws AdminException;

	public List<TripBooking> getAllTrips(Integer customerId) throws TripBookingException;
	
	public List<TripBooking> getTripsCabwise()  throws TripBookingException;
	
	public List<TripBooking> getTripsCustomerwise()  throws TripBookingException;
	
	
	public List<TripBooking> getTripsDatewise()  throws TripBookingException;
	

	public List<TripBooking> getAllTripsForDays(Integer customerId,LocalDateTime fromDate,LocalDateTime toDate) throws TripBookingException;
	
	
	
}
