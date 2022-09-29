package com.cabBooking.services;

import java.util.List;

public interface CabService {
	
	public Cab registerCab(Cab cab) throws CabException;
	
	public Cab updateCab(Cah cab) throws CabException;
	
	public Cab deleteCab(int cabld) throws CabException;
	
	public List<Cab> viewCabsOfType(String carType) throws CabException;
	
	public Integer countCabsOfType(String carType) throws CabException;
}
