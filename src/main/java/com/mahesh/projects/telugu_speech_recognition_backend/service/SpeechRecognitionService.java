package com.mahesh.projects.telugu_speech_recognition_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SpeechRecognitionService {
	
	private final WebClient webClient;
	
	public SpeechRecognitionService(WebClient webClient) {
		this.webClient = webClient;
	}	
	
	public String recognizeAudio(byte[] audioBytes) {
		return webClient.post()
				.uri("/recognize")
				.bodyValue(audioBytes)
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}
}
