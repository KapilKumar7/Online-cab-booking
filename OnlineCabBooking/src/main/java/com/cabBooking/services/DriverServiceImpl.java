package com.cabBooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverDao driverDao;
	
	
	@Override
	public Driver registerDriver(Driver driver) throws DriverException {
		
		Cab cab = driver.getCab();
		CabType cabType = cab.getCabType();
		cab.setSittingCapacity(cabType.sittingCapacity());
		cab.setPerKmRate(cabType.getPrice());
		driver.setCab();
		
		return driverDao.save(driver);
		
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException {
		
		Driver dd = driverDao.findAll(driver).orElseThrow(() -> new DriverException("Driver does'nt exist"));
		
		dd.seCab(driver.getcab());
		dd.setDl(driver.getDl);
		dd.setRating(driver.getRating());
		driverDao.save(dd);
		
		return dd;
	}

	@Override
	public Driver deleteDriver(int driverld) throws DriverException {
		
		Driver driver = driverDao.findById(driverld).orElseThrow(() -> new DriverException("Driver dosen't exist with id : "+ driverId));
		
		driverDao.delete(driver);
		
		return driver;
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverException {
		
		return driverDao.findAll();
	}

	@Override
	public Driver viewDriver(int driverld) throws DriverException {
		
		return driverDao.findById(driverld).orElseThrow(() -> new DriverException("Driver doesn't exist with id :" + driverld));
		
	}
	
	

}
