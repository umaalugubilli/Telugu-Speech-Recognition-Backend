package com.mahesh.projects.telugu_speech_recognition_backend.controller;

import java.io.IOException;
import java.lang.System.Logger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mahesh.projects.telugu_speech_recognition_backend.service.SpeechRecognitionService;

@Controller
public class CalculatorController {
	
	private SpeechRecognitionService speechRecognitionService;
	public CalculatorController(SpeechRecognitionService speechRecognitionService) {
		this.speechRecognitionService = speechRecognitionService;
	}
	
	@PostMapping("/api/calculator")
	public ResponseEntity<?> calculate( 
			@RequestParam("file1") MultipartFile file1,
	        @RequestParam("file2") MultipartFile file2,
	        @RequestParam("operation") String operation) throws IOException{
		
		try {
			
			String tempDir = System.getProperty("java.io.tmpdir"); // Get temp directory
	        Path tempFile1 = Paths.get(tempDir, UUID.randomUUID().toString() + ".wav"); // Unique filename
	        Path tempFile2 = Paths.get(tempDir, UUID.randomUUID().toString() + ".wav");

	        Files.copy(file1.getInputStream(), tempFile1, StandardCopyOption.REPLACE_EXISTING);
	        Files.copy(file2.getInputStream(), tempFile2, StandardCopyOption.REPLACE_EXISTING);
	        
	        int digit1 = speechRecognitionService.recognizeDigit(tempFile1.toString());
	        int digit2 = speechRecognitionService.recognizeDigit(tempFile2.toString());

	        Files.delete(tempFile1); // Clean up
	        Files.delete(tempFile2);

	        int result = 0; // Initialize result
	        
            switch (operation) {
                case "add":
                    result = digit1 + digit2;
                    break;
                case "sub":
                    result = digit1 - digit2;
                    break;
                case "mul":
                    result = digit1 * digit2;
                    break;
                case "div":
                    if (digit2 == 0) {
                        return ResponseEntity.badRequest().body(new CalculationResult("Division by zero"));
                    }
                    result = digit1 / digit2;
                    break;
                default:
                    return ResponseEntity.badRequest().body(new CalculationResult("Invalid operation"));
            }
            
            

            return ResponseEntity.ok(Map.of("result",result));
		}
		catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
		
	}
	
	

}
