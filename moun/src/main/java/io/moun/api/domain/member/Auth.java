package io.moun.api.domain.member;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Embeddable
@Getter
public class Auth {
    @NotNull
    private String email;
    
    @NotNull
    private String password;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @Builder
    public Auth(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
