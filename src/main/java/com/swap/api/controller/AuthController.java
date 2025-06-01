package com.swap.api.controller;

import com.swap.api.dto.AuthDTO;
import com.swap.api.entity.User;
import com.swap.api.repository.UserRepository;
import com.swap.api.service.AuthService;
import com.swap.api.types.UserRole;
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
public class AuthController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthService service;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO request) {
        String managerUsername = service.loadUserByUsername("swap-translator").getUsername();
        User manager = repository.findByLogin(managerUsername).orElse(null);
        if(manager == null) {
            User newManager = new User();
            newManager.setLogin("swap-translator");
            newManager.setPassword(request.getPassword());
            newManager.setRole(UserRole.MANAGER);
            repository.save(newManager);
        }
        manager.setRole(UserRole.MANAGER);
        String passwordEncoded = passwordEncoder.encode(request.getPassword());

        if(!request.getLogin().equals("MANAGER")) return ResponseEntity.badRequest().body("wrong login, only MANAGER here");
        if(!manager.getPassword().equals(passwordEncoded)) return ResponseEntity.badRequest().body("wrong password");
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
        authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.status(200).build();
    }
}
