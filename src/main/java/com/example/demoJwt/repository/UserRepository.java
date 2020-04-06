package com.example.demoJwt.repository;

import com.example.demoJwt.entity.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
    public UserDAO findByMail(String mail);

}
