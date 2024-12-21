package com.mahesh.projects.telugu_speech_recognition_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		return "/calculator.html";
	}

}
