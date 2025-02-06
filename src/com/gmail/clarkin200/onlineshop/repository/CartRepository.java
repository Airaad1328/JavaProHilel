package com.gmail.clarkin200.onlineshop.repository;

import com.gmail.clarkin200.onlineshop.models.Product;

import java.util.List;
import java.util.Optional;

public interface CartRepository<Long, Product> {

    public boolean addProduct(Product entity);

    public boolean deleteProductById(Long id);

    public Optional<List<Product>> showAll();
}
