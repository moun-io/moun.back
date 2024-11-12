package io.moun.api.security.service;

import io.moun.api.security.controller.dto.LoginRequest;
import io.moun.api.security.controller.dto.RegisterRequest;

public interface AuthService {
    public boolean registerAuth(RegisterRequest registerRequest);
    public boolean loginAuth(LoginRequest loginRequest);
}
