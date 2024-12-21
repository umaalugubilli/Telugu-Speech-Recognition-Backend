package com.mahesh.projects.telugu_speech_recognition_backend.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mahesh.projects.telugu_speech_recognition_backend.service.SpeechRecognitionService;

@Controller
@RequestMapping("/api")
public class SpeechController {
	
	private final SpeechRecognitionService speechRecognitionService;
	
	public SpeechController(SpeechRecognitionService speechRecognitionService) {
		this.speechRecognitionService = speechRecognitionService;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadAudio(@RequestParam("file") MultipartFile file){
		try {
			byte[] audioBytes = file.getBytes();
			String response = speechRecognitionService.recognizeAudio(audioBytes);
			return ResponseEntity.ok(response);
		}
		catch(IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File processing failed.");
		}
	}
	
}
