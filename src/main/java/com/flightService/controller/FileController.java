package com.flightService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flightService.dto.FileDto;
import com.flightService.service.FileService;

import lombok.extern.log4j.Log4j2;

/**
 * document related api's
 *
 */
@CrossOrigin(origins = "*")
@RestController
@Log4j2
public class FileController {

	private FileService fileService;

	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}

	/**
	 * upload document
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping(name = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadFile(MultipartFile file, @RequestParam String flightId) {
		log.info("upload file called");
		String message = fileService.uploadFile(file, flightId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	/**
	 * download document based on flightId
	 * 
	 * @param flightId
	 * @return
	 */
	@GetMapping("/download")
	public ResponseEntity<List<FileDto>> downloadFile(@RequestParam List<String> flightIds) {
		log.info("download file called");
		List<FileDto> fileDto = fileService.downloadFile(flightIds);
		return ResponseEntity.status(HttpStatus.OK).body(fileDto);
	}

}
