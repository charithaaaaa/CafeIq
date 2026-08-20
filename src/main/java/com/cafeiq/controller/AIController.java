package com.cafeiq.controller;

import com.cafeiq.dto.AIRequestDTO;
import com.cafeiq.dto.AIResponseDTO;
import com.cafeiq.service.BusinessAdvisorService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class AIController {

    private final BusinessAdvisorService businessAdvisorService;

    public AIController(
            BusinessAdvisorService businessAdvisorService) {

        this.businessAdvisorService = businessAdvisorService;
    }

    @PostMapping("/business-advisor")
    public AIResponseDTO askBusinessAdvisor(
            @RequestBody AIRequestDTO request) {

        String answer =
                businessAdvisorService.getAdvice(
                        request.getQuestion()
                );

        return new AIResponseDTO(answer);
    }
}