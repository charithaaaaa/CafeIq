package com.cafeiq.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public GeminiService(RestClient.Builder builder,
                         ObjectMapper objectMapper) {

        this.restClient = builder
                .baseUrl("https://generativelanguage.googleapis.com")
                .build();

        this.objectMapper = objectMapper;
    }

    public String askGemini(String question) {

        try {

            Map<String, Object> requestBody = Map.of(
                    "contents", List.of(
                            Map.of(
                                    "parts", List.of(
                                            Map.of("text", question)
                                    )
                            )
                    )
            );

            String response = restClient.post()
                    .uri("/v1beta/models/gemini-3.5-flash:generateContent")
                    .header("x-goog-api-key", apiKey)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(requestBody)
                    .retrieve()
                    .body(String.class);

            JsonNode root = objectMapper.readTree(response);

            return root
                    .path("candidates")
                    .path(0)
                    .path("content")
                    .path("parts")
                    .path(0)
                    .path("text")
                    .asText();

        } catch (Exception e) {

            e.printStackTrace();

            return "Sorry, I couldn't generate a response right now.";
        }
    }
}