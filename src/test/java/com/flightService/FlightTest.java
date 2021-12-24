/*
 * package com.flightService;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.time.LocalDate;
 * 
 * import org.junit.jupiter.api.Test; import org.modelmapper.ModelMapper; import
 * org.modelmapper.convention.MatchingStrategies; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean;
 * 
 * import com.flightService.dao.FlightRepository; import
 * com.flightService.dto.FlightDto; import com.flightService.entity.Flight;
 * import com.flightService.service.FlightService;
 * 
 *//**
	 * @author user
	 *
	 */
/*
 * @SpringBootTest public class FlightTest {
 * 
 * private final FlightService flightService;
 * 
 * @MockBean private final FlightRepository flightRepository;
 * 
 * private final ModelMapper modelMapper;
 * 
 * public FlightTest(FlightService flightService, FlightRepository
 * flightRepository,ModelMapper modelMapper) { this.flightService =
 * flightService; this.flightRepository = flightRepository; this.modelMapper =
 * modelMapper; }
 * 
 *//**
	*
	*//*
		 * @Test public void addNewFlightTest() {
		 * modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
		 * ; Flight flight = new Flight(123, "123232", "airindia", "delhi", "bangalore",
		 * LocalDate.parse("2021-12-23"), LocalDate.parse("2021-12-31"), "19:00",
		 * "21:00", "A322", 10, 50, 4500.00, 4, 60, "veg", "running");
		 * when(flightRepository.save(flight)).thenReturn(flight);
		 * 
		 * FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
		 * assertEquals(flight, flightService.addFlight(flightDto));
		 * 
		 * }
		 * 
		 * }
		 */