package com.example.cur.userservice.controller;

import com.example.cur.userservice.model.User;
import com.example.cur.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")


public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.uptade(user);
    }

    @PostMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/{id}")
    public User getById(@RequestBody int id) {
        return userService.getById(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody int id) {
        userService.delete(id);
    }

    @PostMapping("/find/{email}")
    public User getByEmail(@RequestBody String email) {
        return userService.findByEmail(email);
    }


}
