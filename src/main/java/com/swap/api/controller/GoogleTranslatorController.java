package com.swap.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoogleTranslatorController {
    @GetMapping("translate/projects={projects}")
    public List<String> showSupportedLanguages(@PathVariable List<String> projects) {
        Map<String, String> body = new HashMap<>();
        body.put("q", text);

    }

}
