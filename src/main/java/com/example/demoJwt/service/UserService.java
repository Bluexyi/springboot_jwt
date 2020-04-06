package com.example.demoJwt.service;


import com.example.demoJwt.entity.UserDAO;
import com.example.demoJwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDAO add(UserDAO user) {
        return userRepository.save(user);
    }

    public List<UserDAO> getUsers(){
        return userRepository.findAll();
    }

    public UserDAO getByMail(String mail) {
        return userRepository.findByMail(mail);
    }
}
