package com.flightService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

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
