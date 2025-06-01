package com.swap.api.controller;

import com.swap.api.dto.TranslateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.deepl.api.*;

import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/translate")
public class DeeplTranslatorService {
    @Value("${deepl.api-key}")
    private String apiKey;

    @PostMapping
    public ResponseEntity<TranslateRequest> translate(@RequestBody TranslateRequest body) throws DeepLException, InterruptedException {
        Translator translator = new Translator(this.apiKey);
        try {
            TextResult result = translator.translateText(body.getText(), null, body.getLang());
            TranslateRequest response = new TranslateRequest(body.getText(), body.getLang());

            return ResponseEntity.ok(response
            );
        } catch (Exception e) {
            throw e;
        }
    }   
}
