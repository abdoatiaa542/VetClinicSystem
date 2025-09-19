package com.example.Vet.Clinic.System.jwt;


import com.example.Vet.Clinic.System.constant.JwtConstants;
import com.example.Vet.Clinic.System.model.users.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {

    @Value(value = "${application.security.access-token.secret-key}")
    private String secretKey;

    public String generateToken(User user, long expirationMillis) {
        Map<String, Object> claims = Map.of(
                JwtConstants.REGISTRATION_CLAIM, user.getCreatedAt().toString(),
                JwtConstants.ROLE_CLAIM, user.getRole().name(),
                JwtConstants.EMAIL_CLAIM, user.getEmail()
        );

        return generateToken(user.getUsername(), claims, expirationMillis);
    }

    private String generateToken(String subject, Map<String, Object> claims, long expirationMillis) {
        long currentTime = System.currentTimeMillis();
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuer(JwtConstants.ISSUER)
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + expirationMillis))
                .signWith(getSecretKey())
                .compact();
    }


    public boolean isValidToken(String token) {
        return getExpiration(token).after(new Date());
    }

    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    private <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
}