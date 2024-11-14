package io.moun.api.security.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
