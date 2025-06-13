package com.allan.projeto.services;

import com.allan.projeto.models.entities.User;
import com.allan.projeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
}
