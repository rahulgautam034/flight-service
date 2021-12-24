package com.flightService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightService.ui.ErrorResponseModel;

/**
 * handle booking related exceptions
 *
 */
@ControllerAdvice
public class BookingExceptionHandler {

	/**
	 * handle booking exception
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BookingException.class)
	
	public ResponseEntity<ErrorResponseModel> handleBookingException(BookingException e){
		
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		
		errorResponseModel.setCode(HttpStatus.NOT_FOUND);
		errorResponseModel.setMessage(e.getMessage());
		errorResponseModel.setErrorReportingTime(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseModel);
	}
}
