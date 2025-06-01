package com.swap.api.service;

import com.swap.api.entity.User;
import com.swap.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByLogin(username).orElse(null);
    }
    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }

    public User save(User u) {
        return userRepository.save(u);
    }
}
