package com.swap.api.controller;

import com.swap.api.dto.TranslateRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.deepl.api.*;

@RestController
@RequestMapping("/translate")
public class DeeplTranslatorController {
    @Value("${deepl.api-key}")
    private String apiKey;

    @PostMapping
    public ResponseEntity<String> translate(@RequestBody @Valid TranslateRequest body) throws DeepLException, InterruptedException {
        Translator translator = new Translator(this.apiKey);
        try {
            TextResult result = translator.translateText(body.getText(), null, body.getLang());
            return ResponseEntity.ok(result.getText());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
