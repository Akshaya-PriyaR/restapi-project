package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examly.springapp.entity.User;

import jakarta.transaction.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Retrieve all users
    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    // Retrieve a user by ID
    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(@Param("id") Long id);

    // Retrieve a user by username
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findUserByUsername(@Param("username") String username);

    // Update user email by ID
    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
    void updateUserEmail(@Param("id") Long id, @Param("email") String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id = :id")
    int deleteUserById(Long id);

}
