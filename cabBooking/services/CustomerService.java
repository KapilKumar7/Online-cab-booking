package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.CustomerException;
import com.cabBooking.models.Customer;

public interface CustomerService {
	
	public Customer resgisterAdmin(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer, int Id)throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId)  throws CustomerException;
	
	public List<Customer> viewCustomers()throws CustomerException;
	
	public Customer viewCustomer(Integer customerId )throws CustomerException;
	
}