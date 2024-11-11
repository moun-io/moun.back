package io.moun.api.member.controller;

import io.moun.api.member.controller.dto.RegisterRequest;
import io.moun.api.member.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> register(RegisterRequest registerRequest) {
//        return ResponseEntity.ok("d");
        boolean success = authService.registerAuth(registerRequest);
        if(!success) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username is taken!");
        } else{
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered!");
        }
    }
}
