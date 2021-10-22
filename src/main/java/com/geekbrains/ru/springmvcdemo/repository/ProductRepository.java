package com.geekbrains.ru.springmvcdemo.repository;

import com.geekbrains.ru.springmvcdemo.domain.Product;

import java.util.List;

public interface ProductRepository {

    Product get(Long id);

    List<Product> findAll();

}
