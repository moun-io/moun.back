package io.moun.api.security.controller;

import io.moun.api.security.controller.dto.LoginRequest;
import io.moun.api.security.controller.dto.RegisterRequest;
import io.moun.api.security.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping
    public String Hello(){
        return "Hello World";
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest) {
        boolean success = authService.registerAuth(registerRequest);
        if(!success) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username is taken!");
        } else{
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered!");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid  @RequestBody LoginRequest loginRequest) {
        boolean success = authService.loginAuth(loginRequest);
        if(!success) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login failed!");
        } else {
            return ResponseEntity.ok("Login Success");
        }

    }
}
