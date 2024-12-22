package com.mahesh.projects.telugu_speech_recognition_backend.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mahesh.projects.telugu_speech_recognition_backend.service.SpeechRecognitionService;

@Controller
public class SpeechController {
	
	private SpeechRecognitionService speechRecognitionService;
	
	public SpeechController(SpeechRecognitionService speechRecognitionService) {
		super();
		this.speechRecognitionService = speechRecognitionService;
	}
	
	
	@PostMapping("/api/prediction")
	public ResponseEntity<?> recognizeSpeech(
			@RequestParam("file") MultipartFile file1
			) throws IOException {
		
		String tempDir = System.getProperty("java.io.tmpdir");
		Path tempFile = Paths.get(tempDir, UUID.randomUUID().toString() + ".wav");
		
		Files.copy(file1.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
		
		int digit = speechRecognitionService.recognizeDigit(tempFile.toString());
		
		Files.delete(tempFile);
		
		return ResponseEntity.ok(Map.of("result",digit));
	}
	
}
