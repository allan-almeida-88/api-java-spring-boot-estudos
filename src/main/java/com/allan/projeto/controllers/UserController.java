package com.allan.projeto.controllers;

import com.allan.projeto.models.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Maria as", "maria@gmail.com", "1234", "8532323232");

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/one")
    public ResponseEntity<User> findOne() {
        User user = new User(2L, "Maria 2", "mm@gmail.com", "1234", "8532323232");

        return ResponseEntity.ok().body(user);
    }
}
