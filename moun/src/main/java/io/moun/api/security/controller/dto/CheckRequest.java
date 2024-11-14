package io.moun.api.security.controller.dto;

import io.moun.api.security.domain.vo.JwtToken;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckRequest {
    @NotNull
    private JwtToken jwtToken;
}
