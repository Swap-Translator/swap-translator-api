package com.swap.api.repository;

import com.swap.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<String, User> {
    User findByLogin(String login);
}
