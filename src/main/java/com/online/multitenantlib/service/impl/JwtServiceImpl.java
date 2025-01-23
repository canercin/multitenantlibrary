package com.online.multitenantlib.service.impl;

import com.online.multitenantlib.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    private final static String SECRET = "8cc1da2abefc6ae1ee3052b968274a28faa2ca0b2522f6da9fca8f09fc62a43580898ba27763bcc8f00b2dff56a95cc45ecb7d1d275f084143f2d3212d2655322ea4f5c888e67962d704dd522489aa0fe4f12a6cdff36460b881ab18c1314d7d0b44fc2815232a19de8df25d2c8d6bdad8e66ef9c3c749fbc582c043331d7da4";

    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().subject(userDetails.getUsername())
                .issuedAt(new java.util.Date())
                .expiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getKey()).build().parseEncryptedClaims(token).getBody();
    }

    private Key getKey() {
        byte[] apiKeySecretBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(apiKeySecretBytes);
    }
}