package com.cabBooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;
import com.cabBooking.repository.CabDao;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabDao cabDao;
	
	@Override
	public Cab registerCab(Cab cab) throws CabException {
		
		CabType type = cab.getCabType();
		
		cab.setPerKmRate(type.getPrice());
		cab.setSittingCapacity(type.getSittingCapacity());
		return cabDao.save(cab);
	}

	@Override
	public Cab updateCab(Cah cab) throws CabException {
		
		Cab cab1 = new Cab();
		
		cab1.setPerkmRate(cab.getPerkmRate());
		cab1.setAvailable(cab.getAvailable());
		cab1.setSittingCapacity(cab.getSittingCapacity());
		cabDao.save(cab1);
		
		return cab1;
	}

	@Override
	public Cab deleteCab(int cabld) throws CabException {
		
		Cab cab = cabDao.findById(cabld).orElseThrow(() -> new CabException("Cab with Id : "+ cabId + "does not exist.."));
		
		cabDao.delete(cab);
		
		return cab;

		
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {
		
		return cabDao.findAllByCabType(carType);
	}

	@Override
	public Integer countCabsOfType(String carType) throws CabException {
		
		return cabDao.findAllByCabType(carType).size();
	}

}
