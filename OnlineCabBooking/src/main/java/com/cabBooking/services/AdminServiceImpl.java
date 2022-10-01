package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.AdminException;
import com.cabBooking.exceptions.CustomerException;
import com.cabBooking.exceptions.DriverException;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Admin;
import com.cabBooking.models.CurrentUserSession;
import com.cabBooking.models.Customer;
import com.cabBooking.models.Driver;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.AdminDao;
import com.cabBooking.repository.CurrentUserSessionDAO;
import com.cabBooking.repository.CustomerDao;
import com.cabBooking.repository.DriverDao;
import com.cabBooking.repository.TripBookingDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao;
	
	@Autowired 
	private CurrentUserSessionDAO sessionDAO;
	
	@Autowired
	private TripBookingDao bookingDao;
	
	@Autowired
	private TripBookingService bookingService;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private DriverDao driverDao;

	@Override
	public Admin resgisterAdmin(Admin admin) throws AdminException {
	
		Admin adminSaved=admindao.save(admin);
		
		if(adminSaved ==null) {
			throw new AdminException("Either already have an account or details not filled properly");
		}else
			return adminSaved;
		
	}

	@Override
	public Admin update(Admin admin, String username, String uuid) throws AdminException {
				
		CurrentUserSession loggedAdmin=sessionDAO.findByUuid(uuid).orElseThrow(()-> new AdminException("Please provide a valid password to update a Admin"));
			
		if(loggedAdmin.getUserId()==admin.getAdminId()) {
			
			admin.getUser().setUsername(username);	
		}
		Admin updatedAdmin=admindao.save(admin);
		
		if(updatedAdmin ==null)
			throw new AdminException("Updation failed try again with valid entry");
		else
			return updatedAdmin;	
		
		
		
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		
		Admin admin = admindao.findById(adminId).orElseThrow(() -> new AdminException("Admin with id : " + adminId + "does not exist"));
	
		admindao.deleteById(adminId);
		
		return admin;
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerId) throws TripBookingException {
			 
		return bookingService.viewAllTripsCustomer(customerId);
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws TripBookingException {
		return null;
		
	}

 

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)throws TripBookingException {
		
		List<TripBooking> bookings=	bookingDao.getAllTripBetweenDate(customerId, fromDate, toDate);
		
		if(bookings.size()>0) {
			return bookings;
		}
		else
			throw new TripBookingException("No trip booking for the customer "+customerId+ " between "+fromDate+ " and "+toDate);
	}

	@Override
	public List<Customer> getTripsCustomerwise() throws CustomerException {
		List<Customer> listOfCustomers = customerDao.findAll();
		if (listOfCustomers.isEmpty())
			throw new CustomerException("There are no Customers present in the Database");

		return listOfCustomers;
	}

	@Override
	public List<Driver> getTripsDriver() throws DriverException {
		List<Driver> listOfDrivers = driverDao.findAll();
		if (listOfDrivers.isEmpty())
			throw new DriverException("There are no Drivers present in the Database");
		return listOfDrivers;
	}
	
	
	
	
	

}