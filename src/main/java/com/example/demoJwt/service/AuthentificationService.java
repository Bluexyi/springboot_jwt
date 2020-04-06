package com.example.demoJwt.service;

import com.example.demoJwt.entity.UserDAO;
import org.springframework.security.core.userdetails.User;
import com.example.demoJwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthentificationService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        UserDAO user = userRepository.findByMail(userMail);
        return new User(user.getMail(), user.getPassword(), new ArrayList<>());
    }
}
