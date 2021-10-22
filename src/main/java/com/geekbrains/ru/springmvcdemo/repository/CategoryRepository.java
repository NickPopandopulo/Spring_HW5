package com.geekbrains.ru.springmvcdemo.repository;

import com.geekbrains.ru.springmvcdemo.domain.Category;
import com.geekbrains.ru.springmvcdemo.domain.Product;

import java.util.List;

public interface CategoryRepository {

    Category get(Long id);

    List<Category> findAll();

}
