package com.swap.api.controller;

import com.swap.api.dto.AuthDTO;
import com.swap.api.dto.TranslateRequest;
import com.swap.api.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/{anything}")
    public String ping(@PathVariable String anything) {
        return anything;
    }

    @PostMapping
    public User save(AuthDTO request) {
        User user = new User(request.getLogin(), request.getPassword());
        user.
    }
}
