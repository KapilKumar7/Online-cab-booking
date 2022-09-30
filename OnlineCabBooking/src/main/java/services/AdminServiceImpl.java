package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.AdminException;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Admin;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.AdminDao;
import com.cabBooking.repository.TripBookingDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Override
	public Admin resgisterAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin update(Admin admin, String username, String password) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerId) throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsCabwise() throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Autowired
//	private AdminDao admindao;
//	
//	@Autowired
//	private TripBookingDao bookingDao;
//	
//	@Autowired
//	private TripBookingService bookingService;
//
//	@Override
//	public Admin resgisterAdmin(Admin admin) throws AdminException {
//	
//		Admin adminSaved=admindao.save(admin);
//		
//		if(adminSaved ==null) {
//			throw new AdminException("Either already have an account or details not filled properly");
//		}else
//			return adminSaved;
//		
//	}
//
//	@Override
//	public Admin update(Admin admin, String username, String password) throws AdminException {
//		
//		Admin adminPresent =admindao.findById(admin.getAdminId()).orElseThrow(()-> new AdminException("No admin with Admin Id : "+admin.getAdminId()));
//		
//		adminPresent.getUser().setUsername(username);
//		adminPresent.getUser().setPassword(username);
//		
//		return adminPresent;
//		
//	}
//
//	@Override
//	public Admin deleteAdmin(Integer adminId) throws AdminException {
//		
//		Admin admin = admindao.findById(adminId).orElseThrow(() -> new AdminException("Admin with id : " + adminId + "does not exist"));
//	
//		admindao.deleteById(adminId);
//		
//		return admin;
//	}
//
//	@Override
//	public List<TripBooking> getAllTrips(Integer customerId) throws TripBookingException {
//			 
//		return bookingService.viewAllTripsCustomer(customerId);
//	}
//
//	@Override
//	public List<TripBooking> getTripsCabwise() throws TripBookingException {
//		
//		return null;
//	}
//
//	@Override
//	public List<TripBooking> getTripsCustomerwise() throws TripBookingException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<TripBooking> getTripsDatewise() throws TripBookingException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)throws TripBookingException {
//		
//		List<TripBooking> bookings=	bookingDao.getAllTripBetweenDate(customerId, fromDate, toDate);
//		
//		if(bookings.size()>0) {
//			return bookings;
//		}
//		else
//			throw new TripBookingException("No trip booking for the customer "+customerId+ " between "+fromDate+ " and "+toDate);
//	}
//	
//	
	
	
	

}
