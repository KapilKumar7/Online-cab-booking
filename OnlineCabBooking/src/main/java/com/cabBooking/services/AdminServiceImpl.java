package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.AdminException;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.repository.AdminDao;
import com.cabBooking.repository.AdminSessionDao;
import com.cabBooking.repository.TripBookingDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao;
	
	
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Autowired
	private TripBookingDao tripDao;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@Override
	public Admin resgisterAdmin(Admin admin) throws AdminException {
		
		return admindao.save(admin);
	}

	@Override
	public Admin update(Admin admin, String Username, String password) throws AdminException {
		
		Admin updated = null;
		
		Optional<AdminSession> op = adminSessionDao.findByUuid(password);
		
		if(op.isEmpty()) {
			
			throw new LoginException("Please Login first");
		}
		else {
			
			Optional<Admin> otp = admindao.findByUsername(Username);
			
			if(otp.isEmpty()) {
				
				throw new UsernameNotFoundException("Give correct username");
			}
			else {
				
				Admin toUpdate = otp.get();
				Integer id = toUpdate.getAdminId();
				Admin ad = new Admin(id, admin.getUser());
				updated = admindao.save(ad);
			}
		}
	}

	@Override
	public Admin deleteAdmin(Integer AdminId) throws AdminException {
	
		Admin AD = admindao.findById(AdminId).orElseThrow(()-> new AdminException("Admin does not exist with Id : "+AdminId));
		
		admindao.deleteAdmin(AD);
		
		return AD;
		
		
	}

	@Override
	public List<TripBookingService> getAllTrips(Integer customerId) throws TripBookingException {
		
		List<TripBookingService> list = customerService.getList(customerId);
		
		if(list.size()==0) {
			
			throw new TripBookingException("No Trip for this customerId : "+customerId);
		}
		return list;
	}

	@Override
	public List<TripBookingService> getTripsCabwise() throws TripBookingException {
		return null;
		
		
	}

	@Override
	public List<TripBookingService> getTripsCustomerwise() throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBookingService> getTripsDatewise() throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBookingService> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cabBooking.models.Admin resgisterAdmin(com.cabBooking.models.Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cabBooking.models.Admin update(com.cabBooking.models.Admin admin, String Username, String password)
			throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cabBooking.models.Admin deleteAdmin(Integer AdminId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

}
