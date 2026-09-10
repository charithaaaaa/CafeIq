package com.cafeiq.dto;

public class AIResponseDTO {

    private String answer;

    public AIResponseDTO() {
    }

    public AIResponseDTO(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}