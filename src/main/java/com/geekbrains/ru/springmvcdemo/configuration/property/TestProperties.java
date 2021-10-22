package com.geekbrains.ru.springmvcdemo.configuration.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "test.config")
public class TestProperties {

    private int value;
    private String description;

}
