package com.geekbrains.ru.springmvcdemo.dao.impl;

import com.geekbrains.ru.springmvcdemo.dao.ProductDao;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDaoImpl implements ProductDao {

    public static SessionFactory factory;

    @PostConstruct
    private void init() throws IOException {
        factory = new Configuration()
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();

        String sql = Files.lines(Paths.get("table_products.sql")).collect(Collectors.joining(" "));
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createNativeQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Product findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = (List<Product>) session.createQuery("from Product").list();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(session.get(Product.class, id));
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

    @PreDestroy
    private void close() {
        factory.close();
    }
}
