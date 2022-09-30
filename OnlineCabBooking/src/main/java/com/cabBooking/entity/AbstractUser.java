package com.cabBooking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractUser {
	
	private String username;
	private String password;
	private String address;
	private String mobile;
	private String email;	

}
