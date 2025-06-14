package com.allan.projeto.services;

import com.allan.projeto.models.entities.Category;
import com.allan.projeto.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }

    public Category findById(Long id){
        Optional<Category> category = categoryRepository.findById(id);

        return category.get();
    }
}
