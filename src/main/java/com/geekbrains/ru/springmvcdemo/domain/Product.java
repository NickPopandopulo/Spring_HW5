package com.geekbrains.ru.springmvcdemo.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String title;
    private String description;
    private String imageLink;
    private int price;

    private Category category;

}
