package io.moun.api.security.service;

import io.moun.api.security.controller.dto.LoginRequest;
import io.moun.api.security.controller.dto.RegisterRequest;
import io.moun.api.security.domain.vo.JwtToken;

public interface AuthService {
    public boolean registerAuth(RegisterRequest registerRequest);
    public JwtToken loginAuth(LoginRequest loginRequest);
}
