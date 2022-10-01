package com.cabBooking.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ApplicationError {

	
	
	
	private LocalDateTime erroerDateTime;
	private String message;
	 private String details;
	
	

	
}
