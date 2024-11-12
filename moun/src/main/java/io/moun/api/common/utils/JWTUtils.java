package io.moun.api.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JWTUtils {

    private static final int JWT_EXPIRATION_PERIOD= 40000;
    private static final String ENV_JWT_SECRET_KEY = "secretKey";
//            System.getenv("JWT_SECRET_KEY");

    private static final SecretKey JWT_SECRET_KEY = Keys.hmacShaKeyFor(ENV_JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(Authentication authentication) {
        return Jwts.builder()
                .subject(authentication.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_PERIOD))
                .signWith(JWT_SECRET_KEY)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(JWT_SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser().verifyWith(JWT_SECRET_KEY).build().parseSignedClaims(token);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
