package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.CategoryRepository;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final CategoryRepository categoryRepository;

    @Override
    public Product get(Long id) {
        return Product.builder()
                .id(id)
                .title("title " + id)
                .description("Description for product " + id)
                .price(100)
                .category(categoryRepository.get(id))
                .build();
    }

    @Override
    public List<Product> findAll() {
        return List.of(get(1L), get(2L), get(3L));
    }

}
