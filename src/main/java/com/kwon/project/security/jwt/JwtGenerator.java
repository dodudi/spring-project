package com.kwon.project.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtGenerator {
    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    String generateToken(UserDetails userDetails);
}
