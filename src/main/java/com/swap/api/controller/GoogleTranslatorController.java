package com.swap.api.controller;

import com.swap.api.dto.TranslateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/translate")
public class GoogleTranslatorController {
    @Value("{google.url}")
    private String url;
    @Value("{google.api-key}")
    private String apiKey;

    @GetMapping
    public ResponseEntity<String> translate(@RequestBody TranslateRequest body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TranslateRequest> googleRequest = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, googleRequest, String.class);
        return ResponseEntity.ok(response.getBody());
    }

}
