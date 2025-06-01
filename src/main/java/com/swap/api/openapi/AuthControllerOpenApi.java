package com.swap.api.openapi;

import com.swap.api.dto.AuthDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Tag(name = "Auth Controller - Manager")
public interface AuthControllerOpenApi {
    @Operation(summary = "login manager to managers routes")
    ResponseEntity<UsernamePasswordAuthenticationToken> login(AuthDTO request);
    @Operation(summary = "register manager to managers routes")
    ResponseEntity<UsernamePasswordAuthenticationToken> register(AuthDTO request);
}
