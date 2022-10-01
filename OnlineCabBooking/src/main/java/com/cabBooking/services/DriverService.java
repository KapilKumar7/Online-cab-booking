package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.Driver;

public interface DriverService {
	public Driver registerDriver(Driver driver) throws DriverException;
	public Driver updateDriver(int driverId, Driver driver) throws DriverException;
	public Driver deleteDriver(int driverld) throws DriverException;
	public List<Driver> viewBestDrivers() throws DriverException;
	public Driver viewDriver(int driverld) throws DriverException;
}