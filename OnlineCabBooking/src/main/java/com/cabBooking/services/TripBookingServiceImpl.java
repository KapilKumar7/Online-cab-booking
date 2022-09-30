package com.cabBooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.TripBookingDao;

@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	private TripBookingDao tripDao;
	
		
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripBookingException {
		
		TripBooking booking=tripDao.save(tripBooking);
		
		if(booking ==null) {
			throw new TripBookingException("Enter proper details to start the trip");
		}else
			return booking;
		
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException {
		
		tripDao.findById(tripBooking.getTripBookingId()).orElseThrow(() -> new TripBookingException("TripBooking with id : "+ tripBooking.getTripBookingId() + "does not exist"));
	
		return tripDao.save(tripBooking);
		
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingld) throws TripBookingException {
	
		TripBooking trip = tripDao.findById(tripBookingld).orElseThrow(() -> new TripBookingException("Trip with id : " + tripBookingld + "does not exist"));
		
		tripDao.deleteById(tripBookingld);
		
		return trip;
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerld) throws TripBookingException {
		
		List<TripBooking> list=tripDao.getAllTripsByCustomerId(customerld);
		
		if(list.size()==0) throw new TripBookingException("No trip for this customer having id : "+ customerld);
		
		return list;
	}


	
	@Override
	public TripBooking calculateBill(int customerld) throws TripBookingException {
		
		TripBooking trip = tripDao.getCurrentTripByCustomerId(customerld);
		if(trip ==null) {
		 throw new TripBookingException("Trip Booking with id :" + customerld + "does not exist");
		}
		trip.setBill(trip.getDriver().getCab().getPerKmRate() *trip.getDistanceInKm());
		
		trip.setStatus(false);
		
		return tripDao.save(trip);
	}
	
	

}
