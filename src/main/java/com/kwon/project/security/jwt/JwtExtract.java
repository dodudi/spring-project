package com.kwon.project.security.jwt;

import io.jsonwebtoken.Claims;

import java.util.function.Function;

public interface JwtExtract {
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
}
