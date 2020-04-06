package com.example.demoJwt.controller;

import com.example.demoJwt.entity.UserDAO;
import com.example.demoJwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDAO> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<?> post(HttpServletRequest request, @RequestBody @Valid UserDAO user){
        Long userId = userService.add(user).getId();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userId);
    }

}
