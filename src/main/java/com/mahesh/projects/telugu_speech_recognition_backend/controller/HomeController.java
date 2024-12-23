package com.mahesh.projects.telugu_speech_recognition_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String gotoWelcomePage(Model model) {
		//model.addAttribute("pageTitle", "Speech Recognition Calculator");
		return "prediction";
	}

	
	@GetMapping("/calculator")
	public String gotoPredictionPage() {
		return "calculator";
	}
	
	

}
