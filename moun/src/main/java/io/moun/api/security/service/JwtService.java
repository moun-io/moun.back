package io.moun.api.security.service;

import io.jsonwebtoken.Claims;
import io.moun.api.security.domain.vo.JwtToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Payload;
import org.springframework.security.core.Authentication;

public interface JwtService {
    public boolean isValidToken(JwtToken jwtToken);
    public JwtToken generateToken(Authentication authentication);
    public String getUsernameFromToken(JwtToken jwtToken);
    public JwtToken getTokenFromRequest(HttpServletRequest request);
    public Claims getClaimsFromToken(JwtToken jwtToken);
}
