package com.swap.api.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Deepl Controller - Translate")
public interface DeeplTranslatorControllerOpenApi {
    @Operation(summary = "translate the text sended")
    ResponseEntity<String> translate();
}
