package com.cabBooking.services;

import java.util.List;


import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;
import com.cabBooking.models.CabType;

public interface CabService {
	
	public Cab registerCab(Cab cab) throws CabException;
	
	public Cab updateCab(int cabId, Cab cab) throws CabException;
	
	public Cab deleteCab(int cabId) throws CabException;
	
	public List<Cab> viewCabsOfType(CabType CabType) throws CabException;
	
	public Integer countCabsOfType(CabType cabType) throws CabException;
}