package com.flightService.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Passengers {
	
	private String name;

	private int age;

	private String gender;
	
}