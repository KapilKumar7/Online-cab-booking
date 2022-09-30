package com.cabBooking.services;

import java.util.List;


import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;

public interface CabService {
	
	public Cab registerCab(Cab cab) throws CabException;
	
	public Cab updateCab(int cabId, Cab cab) throws CabException;
	
	public Cab deleteCab(int cabId) throws CabException;
	
	public List<Cab> viewCabsOfType(String CabType) throws CabException;
	
	public Integer countCabsOfType(String cabType) throws CabException;
}