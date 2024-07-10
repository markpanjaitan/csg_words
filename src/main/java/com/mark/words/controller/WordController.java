package com.mark.words.controller;

import com.mark.words.service.WordsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api")
@Tag(name = "Words Management")
public class WordController {

	@Autowired
	WordsService wordsService;

	@Operation(description = "Words Counter")
	@PostMapping(path = "/words-counter", consumes = "multipart/form-data")
	public ResponseEntity<?> handleUploadAndCounter(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			return new ResponseEntity<>("Please upload file!", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(wordsService.uploadAndCount(file), HttpStatus.OK);
	}

}
