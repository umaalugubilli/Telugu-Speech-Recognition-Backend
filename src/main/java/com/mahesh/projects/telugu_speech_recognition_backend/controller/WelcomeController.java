package com.mahesh.projects.telugu_speech_recognition_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/calculate")
	public String gotoWelcomePage(Model model) {
		//model.addAttribute("pageTitle", "Speech Recognition Calculator");
		return "calculator";
	}

	
	@GetMapping("/predict")
	public String gotoPredictionPage() {
		return "prediction";
	}
	
	

}
