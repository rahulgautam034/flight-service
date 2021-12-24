package com.flightService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9053315727906717006L;
	private String message;

}
