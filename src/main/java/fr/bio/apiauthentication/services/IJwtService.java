package fr.bio.apiauthentication.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;

public interface IJwtService {
    String generateToken(UserDetails userDetails);

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    String generateRefreshToken(UserDetails userDetails);

    String getUsernameFromToken(String token);

    Date getExpirationDateFromToken(String token);

    boolean validate(String token);

    boolean validateToken(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);
}