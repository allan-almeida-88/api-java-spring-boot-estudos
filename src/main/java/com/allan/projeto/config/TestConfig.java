package com.allan.projeto.config;

import com.allan.projeto.models.entities.Category;
import com.allan.projeto.models.entities.Order;
import com.allan.projeto.models.entities.User;
import com.allan.projeto.models.enums.OrderStatus;
import com.allan.projeto.repositories.CategoryRepository;
import com.allan.projeto.repositories.OrderRepository;
import com.allan.projeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Alberto", "alberto@gmai,com", "1234", "8532320000");
        User u2 = new User(null, "Maria", "mm@gmai,com", "1234", "8522220000");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.valueOf("PAID"));
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.valueOf("SHIPPED"));
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.valueOf("SHIPPED"));

        Category c1 = new Category(null, "Eletronicos");
        Category c2 = new Category(null, "Livros");
        Category c3 = new Category(null, "Computadores");

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
