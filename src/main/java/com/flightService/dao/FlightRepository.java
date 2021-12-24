package com.flightService.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightService.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query
	Flight findByFlightId(String flightId);

	@Query(value = "SELECT * FROM flights u WHERE "
			+ "LOWER(u.source) = :source AND u.destination =:destination AND u.start_date <= :startDate "
			+ "AND u.end_date >= :startDate AND status ='running'", nativeQuery = true)
	List<Flight> findByCriteria(@Param("source") String source, @Param("destination") String destination,
			@Param("startDate") LocalDate startDate);

}
