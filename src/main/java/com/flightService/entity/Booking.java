package com.flightService.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bookedflights")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String pnrNumber;
	
	private String flightName;

	private String flightId;

	private LocalDateTime date;
	
	private LocalDate bookingDate;
	
	private String startTime;

	private String endTime;

	private String source;

	private String destination;

	private String name;

	private String email;

	private Integer totalSeats;

	private String mealType;
	
	private String status;

	@ElementCollection
	private List<Passengers> passengers = new ArrayList<>();

}
