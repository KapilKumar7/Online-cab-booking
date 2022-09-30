package com.cabBooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.CustomerException;
import com.cabBooking.models.Customer;
import com.cabBooking.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	public CustomerService cDao;
	
	
	@PostMapping("/registercustomer")
	public ResponseEntity<Customer> registerCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer registeredCustomer=cDao.resgisterAdmin(customer);
		return new ResponseEntity<Customer>(registeredCustomer,HttpStatus.ACCEPTED);
	}
	
	

	@PutMapping("/updatecustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomerHandler( @PathVariable Integer customerId,@RequestBody Customer customer) throws CustomerException{
		
		Customer updatedCustomer=cDao.updateCustomer(customer, customerId);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.ACCEPTED);
	}
	
	

	@DeleteMapping("/deletecustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable int  customerId) throws CustomerException{
		
		Customer deletedCustomer=cDao.deleteCustomer(customerId);
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.ACCEPTED);
	}
	
	

	@GetMapping("/Customers")
	public ResponseEntity<List<Customer>> allCustomerHandler() throws CustomerException{
		
		List<Customer> Customers=cDao.viewCustomers();
		return new ResponseEntity<List<Customer>>(Customers,HttpStatus.ACCEPTED);
	}

	@GetMapping("/registerCustomer/{customerId")
	public ResponseEntity<Customer> CustomerHandler(@PathVariable int customerId) throws CustomerException{
		
		Customer customer=cDao.viewCustomer(customerId);
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
	
	
	
	
}