package com.swap.api.openapi;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Tag(name = "Auth")
public interface AuthControllerOpenApi {
    ResponseEntity<UsernamePasswordAuthenticationToken> login();
    ResponseEntity<UsernamePasswordAuthenticationToken> register();
}
