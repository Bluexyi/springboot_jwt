package com.example.demoJwt.service;

import com.example.demoJwt.entity.User;
import com.example.demoJwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {
    @Autowired
    private UserRepository userRepository;

    public User authentificate(User user) {
        return  userRepository.findUserByMailAndPassword(user.getMail(), user.getPassword());
    }

}
