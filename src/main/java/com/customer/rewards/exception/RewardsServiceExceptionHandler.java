package com.customer.rewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.customer.rewards.model.ErrorResponse;

@ControllerAdvice
public class RewardsServiceExceptionHandler {

	private static final String CUSTOMER_NOT_FOUND = "CUSTOMER_NOT_FOUND";
	private static final String BAD_REQUEST = "BAD_REQUEST";

	@ExceptionHandler(value = CustomerException.class)
	public ResponseEntity<ErrorResponse> handleCustomerException(CustomerException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorName(CUSTOMER_NOT_FOUND);
		errorResponse.setErrorDescription(exception.getErrorMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleDefaultException(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorName(BAD_REQUEST);
		errorResponse.setErrorDescription("Bad Request");
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
