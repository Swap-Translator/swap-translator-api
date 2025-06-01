package com.swap.api.entity;

import com.swap.api.types.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Column(unique = true, nullable = false)
    private String login;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String password;
    @NotNull
    @NotBlank
    private UserRole role;

    public User(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role == UserRole.MANAGER) return List.of(new SimpleGrantedAuthority("MANAGER"), new SimpleGrantedAuthority("USER"));
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }
}
