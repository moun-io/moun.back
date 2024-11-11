package io.moun.api.member.controller;

import io.moun.api.member.controller.dto.LoginRequest;
import io.moun.api.member.controller.dto.RegisterRequest;
import io.moun.api.member.service.AuthService;
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
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        boolean success = authService.registerAuth(registerRequest);
        if(!success) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username is taken!");
        } else{
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered!");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        authService.loginAuth(loginRequest);
        return ResponseEntity.ok("Login Success");

    }
}
