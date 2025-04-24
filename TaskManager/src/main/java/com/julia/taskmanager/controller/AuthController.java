package com.julia.taskmanager.controller;

import com.julia.taskmanager.model.User;
import com.julia.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User created = userService.registerUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(created);
    }
}