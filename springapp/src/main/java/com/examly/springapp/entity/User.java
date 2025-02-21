package com.examly.springapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private long id;
    private String username;
    public User() {
    }
    private String email;
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
