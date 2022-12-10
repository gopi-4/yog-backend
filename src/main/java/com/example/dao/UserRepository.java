package com.example.dao;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Transactional
    @Query("select u from User u where u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    @Transactional
    @Query("select u from User u")
    public List<User> getAllUsers();
}
