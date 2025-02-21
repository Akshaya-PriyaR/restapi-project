package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null); // Return user if found, otherwise return null
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(long id, User userDetails) {
        if (userRepository.existsById(id)) { // Check if the user exists
            User user = userRepository.findById(id).orElse(null); // Fetch user
    
            if (user != null) { // Ensure user is found
                user.setUsername(userDetails.getUsername()); // Update username
                user.setEmail(userDetails.getEmail());       // Update email
                return userRepository.save(user); // Save and return updated user
            }
        }
        
        System.out.println("User not found");
        return null; // Return null if the user does not exist
    }
    
    public boolean deleteUser(Long id) {
        int deletedCount = userRepository.deleteUserById(id);
        return deletedCount > 0;
    }
    

}
