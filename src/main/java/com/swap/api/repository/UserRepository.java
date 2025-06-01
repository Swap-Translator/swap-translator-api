package com.swap.api.repository;

import com.swap.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, String> {
    Optional<User> findByLogin(String login);
}
