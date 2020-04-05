package com.example.demoJwt.repository;

import com.example.demoJwt.entity.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
    public UserDAO findByMail(String mail);

    @Query("SELECT u FROM User u WHERE u.mail = ?1 and u.password = ?2")
    UserDAO findUserByMailAndPassword(String mail, String password);


}
