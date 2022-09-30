package com.cabBooking.models;

public enum CabType {

	ECONOMY, COMPACT, COMPACT_PREMIUM, MUV, MUV_PREMIUM, LUXURY, SUPER_LUXURY;
	
	double price;

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int sittingCapacity() {
		
		switch (this) {
		case ECONOMY:
			return 4;
		case COMPACT:
			return 4;
		case COMPACT_PREMIUM:
			return 4;
		case MUV:
			return 6;
		case LUXURY:
			return 3;
		case SUPER_LUXURY:
			return 3;
		default:
			return 4;
		}
	}
	
	
	public double getPrice() {
		
		price = 2;
		
		switch (this) {
		case ECONOMY:
			return price *= 1.25;
		case COMPACT:
			return price *=1.5;
		case COMPACT_PREMIUM:
			return price *=1.75;
		case MUV:
			return price *=2;
		case LUXURY:
			return price *=2.5;
		case SUPER_LUXURY:
			return price *=3;
		default:
			return price;
		}
		
	}
}
