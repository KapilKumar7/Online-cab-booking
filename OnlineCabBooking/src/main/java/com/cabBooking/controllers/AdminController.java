package com.cabBooking.controllers;

import java.time.LocalDateTime;
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

import com.cabBooking.exceptions.AdminException;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Admin;
import com.cabBooking.models.TripBooking;
import com.cabBooking.services.AdminService;

@RestController
public class AdminController {
	
	
	@Autowired
	 public AdminService adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdminHandler(@RequestBody Admin admin) throws AdminException{
		
		Admin savedAdmin=adminService.resgisterAdmin(admin);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
		
	}
	
	
	 
	@PutMapping("/admin/{userName}/{password}")
	public ResponseEntity<Admin>updateAdminHandler(@RequestBody Admin admin ,@PathVariable("userName") String userName,@PathVariable("password") String password) throws AdminException{
		
		Admin updatedAdmin=adminService.update(admin, userName, password);
		
		return new ResponseEntity<Admin>(updatedAdmin,HttpStatus.OK);
		
	}
	 
	
	@DeleteMapping("/admin/{adminId}")
	public ResponseEntity<Admin> registerAdminHandler(@PathVariable("adminId") Integer adminId) throws AdminException{
		
		Admin deletedAdmin=adminService.deleteAdmin(adminId);
		
		return new ResponseEntity<Admin>(deletedAdmin,HttpStatus.OK);
		
	}
	 
	//	public List<TripBookingService> getAllTrips(Integer customerId) throws TripBookingException;
	@GetMapping("/tripbookings/{customerId}")
	public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable("customerId") Integer customerId) throws TripBookingException{
		
		List<TripBooking> listOfBooking=adminService.getAllTrips(customerId);
		return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	}
	
	@GetMapping("/tripbookings")
	public ResponseEntity<List<TripBooking>> getAllTripsCabWise() throws TripBookingException{
		
		List<TripBooking> listOfBooking=adminService.getTripsCabwise();
		return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/tripbookingsCustomerWise")
	public ResponseEntity<List<TripBooking>> getAllTripsCustomerWise() throws TripBookingException{
		
		List<TripBooking> listOfBooking=adminService.getTripsCustomerwise();
		return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	}

	
	@GetMapping("/tripbookingsDateWise")
	public ResponseEntity<List<TripBooking>> getAllTripDateWise() throws TripBookingException{
		
		List<TripBooking> listOfBooking=adminService.getTripsDatewise();
		return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	}
	
	//
	//public List<TripBooking> getAllTripsForDays(Integer customerId,LocalDateTime fromDate,LocalDateTime toDate)
	@GetMapping("/tripbookings{customerId}/{fromDate}/{toDate}")
	public ResponseEntity<List<TripBooking>> getAllTripsbetwwenDays(@PathVariable("customerId")Integer customerId,@PathVariable("fromDate")LocalDateTime fromDate, @PathVariable("toDate")LocalDateTime toDate) throws TripBookingException{
		
		List<TripBooking> listOfBooking=adminService.getAllTripsForDays(customerId, fromDate, toDate);
		return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	}
}
