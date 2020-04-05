package com.example.demoJwt.controller;

import com.example.demoJwt.entity.User;
import com.example.demoJwt.service.AuthentificationService;
import com.example.demoJwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/authentification")
@RequiredArgsConstructor
public class AuthentificationController {
    private final AuthentificationService authentificationService;

    @PostMapping
    public ResponseEntity<?> post(HttpServletRequest request, @RequestBody @Valid User user){
        User userFound = authentificationService.authentificate(user);
        if (userFound != null){
            userFound.setPassword(null);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userFound);
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("User NOT Found");
    }

}
