package com.flightService.controller;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightService.dto.BookingDto;
import com.flightService.service.BookingService;

import lombok.extern.log4j.Log4j2;

/**
 * ticket booking related api's
 *
 */
@RestController
@CrossOrigin(origins = "*")
@Log4j2
public class BookingController {

	private BookingService bookingService;

	private ModelMapper modelMapper;

	public BookingController(BookingService bookingService, ModelMapper modelMapper) {
		this.bookingService = bookingService;
		this.modelMapper = modelMapper;
	}

	/**
	 * @param bookFlight
	 * @return
	 */
	@PostMapping("/booking")
	public ResponseEntity<BookingDto> bookFlight(@RequestBody BookingDto bookingDto) {
		log.info("book flight called");
		Random random = new Random();
		bookingDto.setPnrNumber(Integer.toString(random.nextInt()));
		BookingDto res = bookingService.bookFlight(bookingDto);
		return ResponseEntity.status(HttpStatus.OK).body(res);

	}

	/**
	 * find user booked tickets by registered email id
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("/booking/{email}")

	public ResponseEntity<List<BookingDto>> getUserTickets(@PathVariable String email) {
		log.info("getUserTickets called");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<BookingDto> res = bookingService.getUserTickets(email);

		return ResponseEntity.status(HttpStatus.OK).body(res);

	}

	/**
	 * cancel ticket with the help of pnr number
	 * 
	 * @param pnrNumber
	 * @return
	 */
	@PutMapping("/booking/cancel/{pnrNumber}")

	public ResponseEntity<BookingDto> cancelTicket(@PathVariable String pnrNumber) {
		log.info("cancelTicket called");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		BookingDto res = bookingService.cancelTicket(pnrNumber);

		return ResponseEntity.status(HttpStatus.OK).body(res);

	}

	/**
	 * find ticket using pnr number
	 * 
	 * @param pnrNumber
	 * @return
	 */
	@GetMapping("/airline/ticket/{pnrNumber}")
	public ResponseEntity<BookingDto> findTicket(@PathVariable String pnrNumber) {
		log.info("findTicket called");
		BookingDto res = bookingService.findTicket(pnrNumber);

		return ResponseEntity.status(HttpStatus.OK).body(res);

	}

}
