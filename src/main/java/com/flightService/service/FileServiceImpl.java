package com.flightService.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.flightService.dao.FileRepository;
import com.flightService.dto.FileDto;
import com.flightService.entity.FileEntity;
import com.flightService.exception.FileException;

import lombok.extern.log4j.Log4j2;

/**
 * document related api's
 *
 */
@Service
@Log4j2
public class FileServiceImpl implements FileService {

	private FileRepository fileRepository;

	private ModelMapper modelMapper;

	public FileServiceImpl(FileRepository fileRepository, ModelMapper modelMapper) {
		this.fileRepository = fileRepository;
		this.modelMapper = modelMapper;
	}

	/**
	 * upload new document
	 */
	@Override
	public String uploadFile(MultipartFile file, String flightId) {
		log.info("uploadFile called");
		String docName = file.getOriginalFilename();

		try {

			FileEntity fileEntity = fileRepository
					.save(new FileEntity(flightId, docName, file.getContentType(), file.getBytes()));
			if (fileEntity == null) {
				throw new FileException("error while uploading file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "file uploaded Successfully";
	}

	/**
	 * download saved document using flightId
	 */
	@Override
	public List<FileDto> downloadFile(List<String> flightIds) {
		log.info("downloadFile called");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<FileEntity> files = new ArrayList<>();
		List<FileDto> fileDto = new ArrayList<>();
		flightIds.stream().forEach(id -> {
			FileEntity file = fileRepository.findByFlightId(id);
			if (file != null) {
				files.add(file);
			}
		});

		if (files.size() > 0) {
			files.stream().forEach(file -> {
				fileDto.add(modelMapper.map(file, FileDto.class));
			});
		}
		return fileDto;
	}

}
