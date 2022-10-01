package com.cabBooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.TripBooking;
import com.cabBooking.services.TripBookingService;

@RestController
public class TripBookingController {
	
	@Autowired
	 public TripBookingService tripBookingService;

	@PostMapping("/tripbooking")
	public ResponseEntity<TripBooking> registerTripBooking(@RequestBody TripBooking tripBooking) throws TripBookingException{
	
		 TripBooking savedBooking=tripBookingService.insertTripBooking(tripBooking);
		
		return new ResponseEntity<TripBooking>(savedBooking,HttpStatus.OK);		

	}
	

	@PutMapping("/tripbooking")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripBooking) throws TripBookingException{
TripBooking updatedBooking=tripBookingService.updateTripBooking(tripBooking);
		
		return new ResponseEntity<TripBooking>(updatedBooking,HttpStatus.OK);	
	
	}
	
	@DeleteMapping("/tripbooking/{bookingId}")
	public ResponseEntity<TripBooking> deleteTripBooking(@PathVariable("bookingId")  Integer bookingId) throws TripBookingException{
TripBooking deleteBooking=tripBookingService.deleteTripBooking(bookingId);
		
		return new ResponseEntity<TripBooking>(deleteBooking,HttpStatus.OK);	
	
	}
	
	@GetMapping("/tripbooking/{customerid}")
	public ResponseEntity<List<TripBooking>> allTripBooking(@PathVariable("customerid") Integer customerId) throws TripBookingException{
List<TripBooking> savedBooking=tripBookingService.viewAllTripsCustomer(customerId);
		
		return new ResponseEntity<List<TripBooking>>(savedBooking,HttpStatus.OK);	
	
	}
	
	@GetMapping("/tripbookingBill/{customerid}")
	public ResponseEntity<TripBooking> calculateBill(@PathVariable("customerid") Integer customerId) throws TripBookingException{
TripBooking savedBooking=tripBookingService.calculateBill(customerId);
		
		return new ResponseEntity<TripBooking>(savedBooking,HttpStatus.OK);	
	
	}
	
}