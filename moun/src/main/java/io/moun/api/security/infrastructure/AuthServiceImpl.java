package io.moun.api.security.infrastructure;

import io.moun.api.security.controller.dto.CheckRequest;
import io.moun.api.security.controller.dto.LoginRequest;
import io.moun.api.security.controller.dto.RegisterRequest;
import io.moun.api.security.domain.Auth;
import io.moun.api.security.domain.repository.AuthRepository;
import io.moun.api.security.domain.repository.RoleRepository;
import io.moun.api.security.domain.vo.JwtToken;
import io.moun.api.security.service.AuthService;
import io.moun.api.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Autowired
    public AuthServiceImpl(AuthRepository authRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    @Override
    public boolean registerAuth(RegisterRequest registerRequest) {
        if(authRepository.existsByUsername(registerRequest.getUsername())) {
            return false;
        }

        Auth auth = new Auth();
        auth.setUsername(registerRequest.getUsername());
        auth.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        auth.addRole("ROLE_USER");
        authRepository.save(auth);
        return true;
    }
    @Override
    public JwtToken loginAuth(LoginRequest loginRequest)  {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return  jwtService.generateToken(authentication);
        } catch (AuthenticationException e) {
            return null;
        }

    }
    @Override
    public boolean checkAuth(CheckRequest checkRequest) {
        return jwtService.isValidToken(checkRequest.getJwtToken());
    }
}
