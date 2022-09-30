package com.cabBooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.Driver;
import com.cabBooking.services.DriverService;

@RestController
public class DriverController {

	
	@Autowired
	 public DriverService sDriver;
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> registerDriverHandler(@RequestBody Driver driver) throws DriverException{
		 Driver savedDriver=sDriver.registerDriver(driver);
		 return new ResponseEntity<Driver>(savedDriver,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/drivers")
	public ResponseEntity<Driver> updateDriverHandler(@RequestBody Driver driver) throws DriverException{
		 Driver updatedDriver=sDriver.updateDriver(driver);
		 return new ResponseEntity<Driver>(updatedDriver,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> deleteDriverHandler(@PathVariable("driverId") int driverId) throws DriverException{
		 Driver deletedDriver=sDriver.deleteDriver(driverId);
		 return new ResponseEntity<Driver>(deletedDriver,HttpStatus.OK);
	}
	
	
	@GetMapping("/drivers")
	public ResponseEntity<List<Driver>> allDriversHandler() throws DriverException{
		List< Driver> Drivers=sDriver.viewBestDrivers();
		 return new ResponseEntity<List<Driver>>(Drivers,HttpStatus.OK);
	}
	
	
	@GetMapping("/drivers/{driverId}")
	public ResponseEntity<Driver> speciaalDriverHandler(@PathVariable("driverId") int driverId) throws DriverException{
		 Driver Driver=sDriver.viewDriver(driverId);
		 return new ResponseEntity<Driver>(Driver,HttpStatus.OK);
	}
	
}
