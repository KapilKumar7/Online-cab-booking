package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.List;

import com.cabBooking.exceptions.AdminException;
import com.cabBooking.exceptions.CustomerException;
import com.cabBooking.exceptions.DriverException;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Admin;
import com.cabBooking.models.Customer;
import com.cabBooking.models.Driver;
import com.cabBooking.models.TripBooking;


public interface AdminService {
		
	public Admin resgisterAdmin(Admin admin) throws AdminException;

	public Admin update(Admin admin, String username, String uuid)  throws AdminException;

	public Admin deleteAdmin(Integer adminId)  throws AdminException;

	public List<TripBooking> getAllTrips(Integer customerId) throws TripBookingException;
	
	public List<Driver> getTripsDriver()  throws DriverException;
	
	public List<Customer> getTripsCustomerwise()  throws CustomerException;
	
	
	public List<TripBooking> getTripsDatewise()  throws TripBookingException;
	

	public List<TripBooking> getAllTripsForDays(Integer customerId,LocalDateTime fromDate,LocalDateTime toDate) throws TripBookingException;
	
	
	
}
