package com.example.demoJwt.config;

import lombok.Getter;

@Getter
public class AuthentificationResponse {
    private final String jwt;

    public AuthentificationResponse(String jwt) {
        this.jwt = jwt;
    }
}
