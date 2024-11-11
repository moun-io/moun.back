package io.moun.api.member.service;

import io.moun.api.member.controller.dto.LoginRequest;
import io.moun.api.member.controller.dto.RegisterRequest;

public interface AuthService {
    public boolean registerAuth(RegisterRequest registerRequest);
    public void loginAuth(LoginRequest loginRequest);
}
