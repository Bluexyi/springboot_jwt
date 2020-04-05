package com.example.demoJwt.config;

import lombok.Data;

@Data
public class AuthentificationRequest {
    private String mail;
    private String password;

    public AuthentificationRequest() {
    }

    public AuthentificationRequest(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
}
