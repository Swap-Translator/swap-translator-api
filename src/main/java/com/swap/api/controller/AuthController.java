package com.swap.api.controller;

import com.swap.api.dto.AuthDTO;
import com.swap.api.entity.User;
import com.swap.api.openapi.AuthControllerOpenApi;
import com.swap.api.service.AuthService;
import com.swap.api.types.UserRole;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController implements AuthControllerOpenApi {
    @Autowired
    private AuthService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "login with success"))
    @PostMapping("/login")
    public ResponseEntity<UsernamePasswordAuthenticationToken> login(@RequestBody @Valid AuthDTO request) {
        User u = service.findByLogin(request.getLogin());
        String encodedPass = passwordEncoder.encode(request.getPassword());
        if(!u.getPassword().equals(encodedPass)) throw new RuntimeException("wrong password my buddy");
        u.setRole(UserRole.MANAGER);

        var authToken = new UsernamePasswordAuthenticationToken(u.getLogin(), u.getPassword());
        authenticationManager.authenticate(authToken);
        return ResponseEntity.status(200).body(authToken);
    }

    @ApiResponses(value = @ApiResponse(responseCode = "201", description = "register with success"))
    @PostMapping("/register")
    public ResponseEntity<UsernamePasswordAuthenticationToken> register(@RequestBody @Valid AuthDTO request) {
        String encodedPass = passwordEncoder.encode(request.getPassword());
        User u = new User(request.getLogin(), encodedPass);
        u.setRole(UserRole.MANAGER);

        var authToken = new UsernamePasswordAuthenticationToken(u.getLogin(), u.getPassword());
        authenticationManager.authenticate(authToken);
        return ResponseEntity.status(201).body(authToken);
    }
}
