package com.example.cur.userservice.service;

import com.example.cur.userservice.model.User;

import java.util.List;

public interface UserService {
    User getById(int id);
    List<User> findAll();
    User createUser(User user);
    User uptade(User user);
    void delete(int id);
    User findByEmail(String email);
}
