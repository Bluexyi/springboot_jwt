package com.example.demoJwt.repository;

import com.example.demoJwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.mail = ?1 and u.password = ?2")
    User findUserByMailAndPassword(String mail, String password);
}
