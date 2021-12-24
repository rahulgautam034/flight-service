package com.flightService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightService.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {

	FileEntity findByFlightId(String flightId);

}
