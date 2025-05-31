package com.swap.api.controller;

import com.swap.api.dto.TranslateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("{deepl.endpoint}")
    private String url;
    @Value("{deepl.api-key}")
    private String apiKey;
    @Autowired
    private Translator translator;

    @PostMapping
    public ResponseEntity<String> translate(@RequestBody TranslateRequest body) throws DeepLException, InterruptedException {
        translator = new Translator(apiKey);
        TextResult result = translator.translateText("Bom dia!", null, "en");
        return ResponseEntity.ok(result.getText());
    }   
}
