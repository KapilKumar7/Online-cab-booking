package com.cabBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.CustomerException;
import com.cabBooking.models.Customer;
import com.cabBooking.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cDao;
	
	@Override
	public Customer resgisterAdmin(Customer customer) throws CustomerException {
		
		return cDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, int Id) throws CustomerException {
		
		Optional<Customer> cs = cDao.findById(Id);
		
		if(!cs.isPresent()) throw new CustomerException("Customer does not exist with : "+Id);
		
		Customer c = cs.get();
		
		return cDao.save(c);
		
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		
		Customer cs = cDao.findById(customerId).orElseThrow(() -> new CustomerException("Customer does not exist with : "+ customerId));
		cDao.delete(cs);
		return cs;
	}

	@Override
	public List<Customer> viewCustomers() throws CustomerException {

		List<Customer> list = cDao.findAll();
		
		if(list == null)
			throw new CustomerException("No Customers found");
		
		return list;
		
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		
		Customer cs = cDao.findById(customerId).orElseThrow(() -> new CustomerException("customer does not exist with this Id : "+customerId));
		return cs;
	}
	
	

}