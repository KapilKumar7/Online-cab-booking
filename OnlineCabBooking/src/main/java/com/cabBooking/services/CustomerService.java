package com.cabBooking.services;

import java.util.List;

public interface CustomerService {
	
	public Customer resgisterAdmin(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer )throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId)  throws CustomerException;
	
	public List<Customer> viewCustomers()throws CustomerException;
	
	public Customer viewCustomer(Integer customerId )throws CustomerException;
	
}
