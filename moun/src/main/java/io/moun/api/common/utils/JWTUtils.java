package io.moun.api.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class JWTUtils {

    private static final String envJwtSecretKey = System.getenv("JWT_SECRET_KEY");

    private static final SecretKey jwtSecretKey =
            new SecretKeySpec(envJwtSecretKey.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());


    public static Claims getMemberPayLoadsFromJWT(String token) {
        
        return Jwts.parser()
                .verifyWith(jwtSecretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
