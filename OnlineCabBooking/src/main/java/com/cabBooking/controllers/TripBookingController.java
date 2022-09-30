package com.cabBooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.models.TripBooking;
import com.cabBooking.services.TripBookingService;

@RestController
public class TripBookingController {
	
	@Autowired
	 public TripBookingService tripBooking;

	@PostMapping("/tripbooking")
	public ResponseEntity<TripBooking> registerTripBooking(@RequestBody TripBooking tripBooking){
		return null;
		
		

	}
	

	@PutMapping("/tripbooking")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripBooking){
		return null;
	
	}
	
	@DeleteMapping("/tripbooking/{bookingId}")
	public ResponseEntity<TripBooking> deleteTripBooking(@PathVariable("bookingId")  Integer bookingId){
		return null;
	
	}
	
	@GetMapping("/tripbooking/{customerid}")
	public ResponseEntity<List<TripBooking>> allTripBooking(@PathVariable("customerid") Integer customerId){
		return null;
	
	}
	
	@GetMapping("/tripbookingBill/{customerid}")
	public ResponseEntity<TripBooking> calculateBill(@PathVariable("customerid") Integer customerId){
		return null;
	
	}
	
}
