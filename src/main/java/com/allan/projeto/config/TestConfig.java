package com.allan.projeto.config;

import com.allan.projeto.models.entities.User;
import com.allan.projeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Alberto", "alberto@gmai,com", "1234", "8532320000");
        User u2 = new User(null, "Maria", "mm@gmai,com", "1234", "8522220000");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
