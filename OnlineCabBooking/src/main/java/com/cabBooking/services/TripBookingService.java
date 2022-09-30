package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.TripBooking;

public interface TripBookingService {
	
	public TripBooking insertTripBooking(TripBooking tripBooking)throws TripBookingException;
	
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException;
	
	public TripBooking deleteTripBooking(int tripBookingld) throws TripBookingException;
	
	public List<TripBooking> viewAllTripsCustomer(int customerld) throws TripBookingException;
	
	public TripBooking calculateBill(int customerld) throws TripBookingException;
}
