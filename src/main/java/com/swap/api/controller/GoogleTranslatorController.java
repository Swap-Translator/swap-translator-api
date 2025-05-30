package com.swap.api.controller;

import com.swap.api.dto.TranslateRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/translate")
public class GoogleTranslatorController {
    @GetMapping
    public List<String> translate(@RequestBody TranslateRequest body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TranslateRequest> googleRequest = new HttpEntity<>(body, headers);
    }

}
