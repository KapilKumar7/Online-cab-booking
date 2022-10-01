package com.cabBooking.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractUser {
	@NotNull(message = "empty field")
	@Pattern(regexp = "^[a-zA-Z0-9]{3,25}", message = "length must be greater than 3")
	private String username;
	@NotNull(message = "empty field")
	@Pattern(regexp = "^[a-zA-Z0-9]{8,25}", message = "length must be greater than 8")
	private String password;
	
	private String address;
	@NotNull(message = "Enter the mobile Number")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	private String mobile;
	@NotNull(message = "empty field")
	@Email
	private String email;	

}