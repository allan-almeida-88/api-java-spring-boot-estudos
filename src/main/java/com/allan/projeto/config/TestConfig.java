package com.allan.projeto.config;

import com.allan.projeto.models.entities.*;
import com.allan.projeto.models.enums.OrderStatus;
import com.allan.projeto.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        Product p1 = new Product(null, "Livro 1", "breve descrição 1", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "breve descrição 2", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "breve descrição 3", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "breve descrição 4", 1200.0, "");
        Product p5 = new Product(null, "Livro 2", "breve descrição 5", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p3.getCategories().add(c1);
        p3.getCategories().add(c3);
        p4.getCategories().add(c1);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));


    }
}
