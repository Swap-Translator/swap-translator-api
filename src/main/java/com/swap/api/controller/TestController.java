package com.swap.api.controller;

import com.swap.api.dto.AuthDTO;
import com.swap.api.dto.TranslateRequest;
import com.swap.api.entity.User;
import com.swap.api.repository.UserRepository;
import com.swap.api.types.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/{anything}")
    public String ping(@PathVariable String anything) {
        return anything;
    }

    @PostMapping
    public User save(AuthDTO request) {
        User user = new User(request.getLogin(), request.getPassword());
        user.setRole(UserRole.USER);
        return repository.save(user);
    }
}
