package com.flightService.service;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.flightService.dao.BookingRepository;
import com.flightService.dto.BookingDto;
import com.flightService.entity.Booking;
import com.flightService.exception.BookingException;

import lombok.extern.log4j.Log4j2;

/**
 * Book ticket related api implementation
 *
 */

@Service
@Log4j2
public class BookingServiceImpl implements BookingService {

	private final ModelMapper modelMapper;
	private final BookingRepository bookingRepository;

	public BookingServiceImpl(ModelMapper modelMapper, BookingRepository bookingRepository) {
		this.modelMapper = modelMapper;
		this.bookingRepository = bookingRepository;
	}

	/**
	 * book new flight
	 */
	@Override
	public BookingDto bookFlight(BookingDto bookingDto) {
		log.info("bookFlight called");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		bookingDto.setStatus("booked");
		Booking booking = modelMapper.map(bookingDto, Booking.class);
		Booking bookedTicket = bookingRepository.save(booking);
		if (bookedTicket.getPnrNumber() != null) {
			sendMail(booking);
		}
		return modelMapper.map(bookedTicket, BookingDto.class);
	}

	/**
	 * cancel booked ticket using email id
	 */
	@Override
	public BookingDto cancelTicket(String email) {
		log.info("cancelTicket called");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Booking flight = bookingRepository.findByPnrNumber(email);

		if (flight == null) {
			throw new BookingException("flight not found");
		}
		flight.setStatus("cancelled");
		Booking res = bookingRepository.save(flight);
		return modelMapper.map(res, BookingDto.class);
	}

	/**
	 * get booked ticket using pnrNumber
	 */
	@Override
	public BookingDto findTicket(String pnrNumber) {
		log.info("findTicket called");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Booking flight = bookingRepository.findByPnrNumber(pnrNumber);
		if (flight == null) {
			throw new BookingException("flight not found");
		}
		return modelMapper.map(flight, BookingDto.class);
	}

	/**
	 * get all booked ticket by email Id
	 */
	@Override
	public List<BookingDto> getUserTickets(String email) {
		log.info("getUserTickets called");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<Booking> booking = bookingRepository.findAllByEmail(email);
		if (booking == null) {
			throw new BookingException("flight not found");
		}
		List<BookingDto> tickets = booking.stream().map(ticket -> modelMapper.map(ticket, BookingDto.class))
				.collect(Collectors.toList());

		return tickets;
	}

	/**
	 * send mail after ticket booking
	 *
	 */
	public void sendMail(Booking ticket) {
		log.info("sendMail called");
		// Sender's email ID needs to be mentioned
		String from = "harishgautam0909@gmail.com";

		// Assuming you are sending email from through gmails smtp
		final String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("harishgautam0909@gmail.com", "*********");

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(ticket.getEmail()));

			// Set Subject: header field
			message.setSubject("Booking Detail of PNR" + ticket.getPnrNumber());

			// Now set the actual message
			message.setText("Dear " + ticket.getName() + ",\n\n Ticket from " + ticket.getSource() + " to "
					+ ticket.getDestination() + " Booked successfully " + " with PNR number-" + ticket.getPnrNumber()
					+ ".");

			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
