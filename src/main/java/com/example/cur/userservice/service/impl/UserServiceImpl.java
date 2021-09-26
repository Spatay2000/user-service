package com.example.cur.userservice.service.impl;

import com.example.cur.userservice.model.User;
import com.example.cur.userservice.repository.UserRepo;
import com.example.cur.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public User getById(int id) {

        return userRepo.getById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User uptade(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(int id) {
    User user1 = userRepo.getById(id);
    userRepo.delete(user1);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);

        if (user == null){
            throw new UsernameNotFoundException("User: " + username + " not found");
        }
        return user;
    }
}
