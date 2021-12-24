package com.flightService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileException extends RuntimeException {

	private static final long serialVersionUID = -4462986514403019075L;

	private String message;

}
