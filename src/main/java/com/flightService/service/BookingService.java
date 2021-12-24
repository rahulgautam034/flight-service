package com.flightService.service;

import java.util.List;

import com.flightService.dto.BookingDto;

public interface BookingService {

	BookingDto bookFlight(BookingDto bookingDto);

	BookingDto cancelTicket(String pnrNumber);

	BookingDto findTicket(String pnrNumber);

	List<BookingDto> getUserTickets(String email);

}
