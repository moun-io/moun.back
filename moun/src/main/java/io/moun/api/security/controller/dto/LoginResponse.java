package io.moun.api.security.controller.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String tokenValue;
    private String tokenType;
    public LoginResponse(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}
