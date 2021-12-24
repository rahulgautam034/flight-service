package com.flightService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightService.ui.ErrorResponseModel;

/**
 * upload/download file related exception handling
 *
 */
@ControllerAdvice
public class FileExceptionHandler {

	@ExceptionHandler(FileException.class)
	public ResponseEntity<ErrorResponseModel> handleFileException(FileException e){
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		
		errorResponseModel.setCode(HttpStatus.NOT_FOUND);
		errorResponseModel.setMessage(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseModel);
		
	}
}
