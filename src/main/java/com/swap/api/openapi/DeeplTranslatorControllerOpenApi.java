package com.swap.api.openapi;

import org.springframework.http.ResponseEntity;

public interface DeeplTranslatorControllerOpenApi {
    ResponseEntity<String> translate();
}
