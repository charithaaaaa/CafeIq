package com.cafeiq.dto;

public class AIRequestDTO {

    private String question;

    public AIRequestDTO() {
    }

    public AIRequestDTO(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}