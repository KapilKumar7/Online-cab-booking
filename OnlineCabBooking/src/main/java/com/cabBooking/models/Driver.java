package com.cabBooking.models;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer driverId;
	private Float rating;
	private String licenceId;
	@Embedded
	private AbstractUser user;
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	

}