package com.mahesh.projects.telugu_speech_recognition_backend.service;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SpeechRecognitionService {
	
	WebClient webClient = WebClient.create("http://127.0.0.1:8000");

	public int recognizeDigit(String filePath) {
	    try {
	        File file = Paths.get(filePath).toFile();
	        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
	        body.add("file", new FileSystemResource(file));

	        return webClient.post()
	                .uri("/recognize")
	                .contentType(MediaType.MULTIPART_FORM_DATA)
	                .body(BodyInserters.fromMultipartData(body))
	                .retrieve()
	                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
	                .map(response -> {
	                    if (response != null && response.containsKey("predicted_digit")) {
	                        return Integer.parseInt(response.get("predicted_digit"));
	                    } else {
	                        // Handle error
	                        return -1;
	                    }
	                })
	                .block();
	    } catch (Exception e) {
	        // Handle error
	        return -1;
	    }
    }
}
