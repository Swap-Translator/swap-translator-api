package com.swap.api.controller;

import com.swap.api.dto.AuthDTO;
import com.swap.api.entity.User;
import com.swap.api.types.UserRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO request) {
        User manager = new User();
        manager.setRole(UserRole.MANAGER);
        if(!request.getLogin().equals("MANAGER")) return ResponseEntity.badRequest().body("wrong login");
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
        authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.status(200).build();
    }
}
