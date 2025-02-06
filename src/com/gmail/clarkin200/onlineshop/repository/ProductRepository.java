package com.gmail.clarkin200.onlineshop.repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository<Long, Product> {
    Product createProduct(Product entity);

    Optional<List<Product>> getAll();

    Optional<Product> getById(Long id);

    boolean deleteById(Long id);

    Product updateProductById(Product entity);
}
