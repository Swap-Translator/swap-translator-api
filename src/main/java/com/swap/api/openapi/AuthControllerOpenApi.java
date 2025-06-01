package com.swap.api.openapi;

import com.swap.api.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Tag(name = "Auth")
public interface AuthControllerOpenApi {
    @Operation(summary = "login manager to managers routes")
    ResponseEntity<UsernamePasswordAuthenticationToken> login();
    @Operation(summary = "register manager to managers routes")
    ResponseEntity<UsernamePasswordAuthenticationToken> register();
}
