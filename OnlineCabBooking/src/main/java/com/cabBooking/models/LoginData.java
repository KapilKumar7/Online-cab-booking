package com.cabBooking.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class LoginData {
	
	@Id
	@NotNull
	private Integer userId;
	
	private String userName;
	
	private String password;

}
