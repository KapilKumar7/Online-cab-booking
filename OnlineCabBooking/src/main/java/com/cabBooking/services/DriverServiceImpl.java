package com.cabBooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.Cab;
import com.cabBooking.models.CabType;
import com.cabBooking.models.Driver;
import com.cabBooking.repository.DriverDao;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverDao dDao;
	
	@Override
	public Driver registerDriver(Driver driver) throws DriverException {
		
		Cab cab = driver.getCab();
		
		CabType cabtype = cab.getCabtype();
		cab.setSittingCapacity(cabtype.sittingCapacity());
		cab.setPerKmRate(cabtype.getPrice());
		driver.setCab(cab);
		return dDao.save(driver);
	}

	@Override
	public Driver updateDriver(int driverId, Driver driver) throws DriverException {
		
		Driver dd = dDao.findById(driverId).orElseThrow(() -> new DriverException("Driver does not exist with id : "+ driverId));
		dd.setCab(driver.getCab());
		dd.setLicenceId(driver.getLicenceId());
		dd.setRating(driver.getRating());
		dDao.save(dd);
		return dd;
	}

	@Override
	public Driver deleteDriver(int driverld) throws DriverException {
		
		Driver driver = dDao.findById(driverld).orElseThrow(() -> new DriverException("Driver does not exist with id : "+driverld));
		dDao.delete(driver);
		return driver;
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverException {
		
		List<Driver> list = dDao.findAll();
		
		if(list == null)
			throw new DriverException("No Driver found");
		
		return list;
	}

	@Override
	public Driver viewDriver(int driverld) throws DriverException {
		
		return dDao.findById(driverld).orElseThrow(() -> new DriverException("Driver doesn't exist with id :"+ driverld));
	}
	
	

}
