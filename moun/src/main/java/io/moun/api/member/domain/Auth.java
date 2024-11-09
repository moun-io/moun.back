package io.moun.api.member.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
