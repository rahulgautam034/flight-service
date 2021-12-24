package com.flightService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileDto {

	private String flightId;

	private String name;

	private String fileType;

	private byte[] img;
	
}
