package com.cabBooking.exceptions;

import java.time.LocalDateTime;

import javax.persistence.RollbackException;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CabException.class)
	ResponseEntity<ApplicationError>cabExceptionHandler(CabException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(DriverException.class)
	ResponseEntity<ApplicationError>driverExceptionHandler(DriverException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	

	
	@ExceptionHandler(LoginException.class)
	ResponseEntity<ApplicationError>LoginExceptionHandler(LoginException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(TripBookingException.class)
	ResponseEntity<ApplicationError>tripBookingExceptionHandler(TripBookingException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(AdminException.class)
	ResponseEntity<ApplicationError>adminExceptionHandler(AdminException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(CustomerException.class)
	ResponseEntity<ApplicationError>customExceptionHandler(CustomerException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<ApplicationError>noHandlerExceptionHandler(NoHandlerFoundException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(RollbackException.class)
	ResponseEntity<ApplicationError>rollbackExceptionHandler(RollbackException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),"Improper argument passing in JSON,validation error ",wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ApplicationError>methodArgumentExceptionHandler(MethodArgumentNotValidException ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),"Validation Error ",ce.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	
	
//**********************Main-Exception handler******************************

	@ExceptionHandler(Exception.class)
	ResponseEntity<ApplicationError>mainExceptionHandler(Exception ce,WebRequest wr){
		ApplicationError error=new ApplicationError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ApplicationError>(error,HttpStatus.NOT_FOUND);
	}
	
	
	

}
