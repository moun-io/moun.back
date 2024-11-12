package io.moun.api.security.infrastructure;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.moun.api.security.domain.vo.JwtToken;
import io.moun.api.security.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtServiceImpl implements JwtService {

    private static final int JWT_EXPIRATION_PERIOD= 4000000;
    private static final String ENV_JWT_SECRET_KEY = "your-32-characters-or-longer-secret-key";

//            System.getenv("JWT_SECRET_KEY");

    private static final SecretKey JWT_SECRET_KEY = Keys.hmacShaKeyFor(ENV_JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));



    @Override
    public JwtToken generateToken(Authentication authentication) {
        String tokenValue =Jwts.builder()
                .subject(authentication.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_PERIOD))
                .signWith(JWT_SECRET_KEY)
                .compact();
        return new JwtToken(tokenValue);
    }

    @Override
    public String getUsernameFromToken(JwtToken jwtToken) {
        Claims claims = Jwts.parser()
                .verifyWith(JWT_SECRET_KEY)
                .build()
                .parseSignedClaims(jwtToken.getValue())
                .getPayload();
        return claims.getSubject();
    }

    @Override
    public JwtToken getTokenFromRequest(HttpServletRequest request) {
        String bearerTokenValue = request.getHeader("Authorization");
        if (bearerTokenValue != null && bearerTokenValue.startsWith("Bearer ")) {
            return new JwtToken(bearerTokenValue.substring(7));
        }
        return null;
    }

    @Override
    public boolean isValidToken(JwtToken jwtToken) {
        try{
            Jwts.parser().verifyWith(JWT_SECRET_KEY).build().parseSignedClaims(jwtToken.getValue());
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
