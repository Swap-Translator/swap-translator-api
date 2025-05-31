package com.swap.api.types;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("user"),
    MANAGER("manager");
    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
