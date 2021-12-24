package com.flightService.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.flightService.dto.FileDto;

public interface FileService {

	public String uploadFile(MultipartFile file,String flightId);

	public List<FileDto> downloadFile(List<String> flightIds);

}
