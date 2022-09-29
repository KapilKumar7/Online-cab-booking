package com.cabBooking.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public Customer resgisterAdmin(Customer customer) throws CustomerException {
		
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		
		Customer customerDB = customerDao.findAll(customer).orElseThrow(() -> new CustomerException("Admin doesn't exist..."));

		if(Objects.nonNull(customer.getUsername()) &&
				!"".equalsIgnoreCase(customer.getUsername()))
			customerDB.setUsername(customer.getUsername());
		
		if(Objects.nonNull(customer.getName()) &&
				!"".equalsIgnoreCase(customer.getName()))
			customerDB.setName(customer.getName);
		
		if(Objects.nonNull(customer.getPassword()) &&
				!"".equalsIgnoreCase(customer.getPassword()))
			customerDB.setPassword(customer.getPassword);
		
		if(Objects.nonNull(customer.getEmail()) &&
				!"".equalsIgnoreCase(customer.getEmail()))
			customerDB.setEmail(customer.getEmail);
		
		if(Objects.nonNull(customer.getMobileNo()) &&
				!"".equalsIgnoreCase(customer.getMobileNo()))
			customerDB.setMobileNo(customer.getMobileNo);
		
		return customerDao.save(customerDB);
		
			
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		
		Customer customer = customerDao.findById(customerId).orElseThrow(() -> new CustomerException("Customer doesn't exist with this Id : "+ customerId));
		
		customerDao.delete(customer);
		
		return customer;
	}

	@Override
	public List<Customer> viewCustomers() throws CustomerException {
		
		return customerDao.findAll();
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		
		Customer customer = customerDao.findById(customerId).orElseThrow(() -> new CustomerException("Customer doesn't exist with this Id : "+ customerId));
		
		return customer;
	}

	

}
