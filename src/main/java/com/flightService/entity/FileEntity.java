package com.flightService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "documents")
public class FileEntity {

	@Id
	private String flightId;
	
	private String name;
	
	private String fileType;
	
	@Lob
	private byte [] img;

}
