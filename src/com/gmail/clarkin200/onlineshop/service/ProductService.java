package com.gmail.clarkin200.onlineshop.service;

import com.gmail.clarkin200.onlineshop.models.Product;
import com.gmail.clarkin200.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("productService")
public class ProductService {
    ProductRepository<Long, Product> productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(Product entity) {
        return productRepository.createProduct(entity);
    }

    public Optional<List<Product>> getAllProductFromShop() {
        return productRepository.getAll();
    }

    public Optional<Product> getByIdFromShop(Long id) {
        return productRepository.getById(id);
    }

    public boolean deleteByIdFromShop(Long id) {
        return productRepository.deleteById(id);
    }

    public Product updateProductById(Product entity) {
        return productRepository.updateProductById(entity);
    }
}
