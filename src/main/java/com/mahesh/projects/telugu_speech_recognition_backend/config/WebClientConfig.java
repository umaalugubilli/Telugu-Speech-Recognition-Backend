package com.mahesh.projects.telugu_speech_recognition_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl("http://127.0.0.1:8000").build();
	}

}