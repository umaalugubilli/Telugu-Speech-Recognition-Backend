package com.mahesh.projects.telugu_speech_recognition_backend.controller;

public class CalculationResult {
	private String result;

    // Default constructor (required for Jackson)
    public CalculationResult() {
    }

    public CalculationResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
