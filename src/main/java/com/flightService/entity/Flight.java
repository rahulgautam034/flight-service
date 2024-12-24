package com.flightService.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flights")

public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String flightId;

	private String airLine;

	private String source;

	private String destination;

	private LocalDate startDate;

	private LocalDate endDate;

	private String startTime;

	private String endTime;

	private String instrumentUsed;

	private Integer businessClassSeats;

	private Integer nonBusinessClassSeats;

	private Double ticketCost;

	private Integer totalRows;

	private Integer totalSeats;

	private String meal;

	private String status;

	public Flight(String flightId, String airLine, String source, String destination, LocalDate startDate,
			LocalDate endDate, String startTime, String endTime, String instrumentUsed, Integer businessClassSeats,
			Integer nonBusinessClassSeats, Double ticketCost, Integer totalRows, Integer totalSeats, String meal,
			String status) {
		this.flightId = flightId;
		this.airLine = airLine;
		this.source = source;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instrumentUsed = instrumentUsed;
		this.businessClassSeats = businessClassSeats;
		this.nonBusinessClassSeats = nonBusinessClassSeats;
		this.ticketCost = ticketCost;
		this.totalRows = totalRows;
		this.totalSeats = totalSeats;
		this.meal = meal;
		this.status = status;
	}
	
	
}
