package com.example.demoJwt.controller;

import com.example.demoJwt.config.AuthentificationRequest;
import com.example.demoJwt.config.AuthentificationResponse;
import com.example.demoJwt.entity.UserDAO;
import com.example.demoJwt.service.AuthentificationService;
import com.example.demoJwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthentificationController {
    private final AuthentificationService authentificationService; //????????????????????????????

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;


    @RequestMapping(value = "/authentification", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentificationToken(HttpServletRequest request, @RequestBody @Valid AuthentificationRequest authentificationRequest) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getMail(), authentificationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect mail or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authentificationRequest.getMail());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthentificationResponse(jwt) + userDetails.toString());

    }

}
