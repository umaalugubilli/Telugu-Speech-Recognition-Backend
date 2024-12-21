package com.mahesh.projects.telugu_speech_recognition_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DialerController {
	
	@GetMapping("/api/dailer")
	public ResponseEntity<String> dialer(@RequestParam String phone_number){
		return ResponseEntity.ok("Dialing: "+ phone_number);
	}

}
