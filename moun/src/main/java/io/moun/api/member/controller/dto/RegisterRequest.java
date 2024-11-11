package io.moun.api.member.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
