package com.flightService.ui;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * return model if exception occured
 *
 */
@NoArgsConstructor
@Getter
@Setter

public class ErrorResponseModel {

	private HttpStatus code;

	private String message;
	
    private Long errorReportingTime;


}
