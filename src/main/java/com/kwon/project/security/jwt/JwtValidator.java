package com.kwon.project.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtValidator {
    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);
}
