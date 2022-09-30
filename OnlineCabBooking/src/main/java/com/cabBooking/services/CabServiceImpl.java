package com.cabBooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;
import com.cabBooking.models.CabType;
import com.cabBooking.repository.CabDao;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabDao cabDao;

	
	@Override
	public Cab registerCab(Cab cab) throws CabException {
		
		CabType type = cab.getCabtype();
		
		cab.setPerKmRate(type.getPrice());
		cab.setSittingCapacity(type.sittingCapacity());
		
		return cabDao.save(cab);
		
		
	}

	@Override
	public Cab updateCab(int cabId, Cab cab) throws CabException {
		
		Cab cab1 = cabDao.findById(cabId).orElseThrow(() -> new CabException("Cab with Id: "+ cabId + "does not exist"));
		cab1.setPerKmRate(cab.getPerKmRate());
		cab1.setAvailable(cab.getAvailable());
		cab1.setCabtype(cab.getCabtype());
		cab1.setSittingCapacity(cab.getSittingCapacity());
		cabDao.save(cab1);
		return cab1;
	}

	@Override
	public Cab deleteCab(int cabId) throws CabException {
		
		Cab cab = cabDao.findById(cabId).orElseThrow(() -> new CabException("Cab with Id: "+ cabId + "does not exist"));
		cabDao.delete(cab);
		return cab;
		
	}

	@Override
	public List<Cab> viewCabsOfType(String CabType) throws CabException {
		
		return cabDao.findAllByCabType(CabType);
	}

	@Override
	public Integer countCabsOfType(String cabType) throws CabException {
		
		return cabDao.findAllByCabType(cabType).size();
	}
	
	

}
