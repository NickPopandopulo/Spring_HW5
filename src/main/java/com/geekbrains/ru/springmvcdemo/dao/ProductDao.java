package com.geekbrains.ru.springmvcdemo.dao;

import com.geekbrains.ru.springmvcdemo.domain.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
