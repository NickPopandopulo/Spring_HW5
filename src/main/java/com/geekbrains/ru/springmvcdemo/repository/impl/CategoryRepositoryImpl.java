package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.domain.Category;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.CategoryRepository;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public Category get(Long id) {
        return Category.builder()
                .id(id)
                .name("title " + id)
                .alias("title_" + id)
                .build();
    }

    @Override
    public List<Category> findAll() {
        return List.of(get(1L), get(2L), get(3L));
    }

}
