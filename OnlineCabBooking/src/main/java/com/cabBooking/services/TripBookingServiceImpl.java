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
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripBookingException {
		
		return tripDao.save(tripBooking);
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException {
		
		TripBooking trip = tripDao.findAll(tripBooking).orElseThrow(() -> new TripBookingException("TripBooking with id : "+ tripBooking + "does not exist"));
		
		trip.setFromLocation(tripBooking.getFromLocation());
		trip.setToLocation(tripBooking.getToLocation());
		trip.setFromDateTime(tripBooking.getFromDateTime());
		trip.setToDateTime(tripBooking.getToDateTime());
		trip.setBill(tripBooking.getBill());
		trip.setStatus(tripBooking.getStatus());
		trip.setDistanceInKm(tripBooking.getDistanceInKm());
		tripDao.save(trip);
		
		return trip;
		
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingld) throws TripBookingException {
	
		TripBooking trip = tripDao.findById(tripBookingld).orElseThrow(() -> new TripBookingException("Trip with id : " + tripBookingld + "does not exist"));
		
		tripDao.deleteById(tripBookingld);
		
		return trip;
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerld) throws TripBookingException {
		
		List<TripBooking> list = customerService.getList(customerld);
		
		if(list.size()==0) throw new TripBookingException("No trip for this customer having id : "+ customerld);
		
		return list;
	}

	@Override
	public TripBooking calculateBill(int customerld) throws TripBookingException {
		
		TripBooking trip = tripDao.findById(customerld).orElseThrow(() -> new TripBookingException("TripBooking with id :" + customerld + "does not exist"));
		
		Double bill = trip.getBill();
		
		if(bill==0) throw new TripBookingException("No trip/bill found for customerId : "+ customerld);
		
		return bill;
	}
	
	

}
