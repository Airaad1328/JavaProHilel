package com.gmail.clarkin200.onlineshop.repository;

import com.gmail.clarkin200.onlineshop.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("productRepository")
public class ProductRepositoryImpl implements ProductRepository<Long, Product> {

    private List<Product> repository;

    public ProductRepositoryImpl() {
        repository = new ArrayList<>();
        createProduct(new Product("Potato",4.99F));
        createProduct(new Product("Phone",399.99F));
        createProduct(new Product("Carrot",2.25F));
    }

    @Override
    public Product createProduct(Product entity) {
        if (repository.isEmpty()) {
            entity.setId(1L);
            repository.addLast(entity);
        } else {
            entity.setId(repository.getLast().getId() + 1);
            repository.addLast(entity);
        }
        return entity;
    }

    @Override
    public Optional<List<Product>> getAll() {
        return Optional.of(repository);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return repository.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst();
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.removeIf(entity -> entity.getId() == id);
    }

    @Override
    public Product updateProductById(Product newProduct) {
        repository.replaceAll(product -> (product.getId() == newProduct.getId()) ? newProduct:product);
        return newProduct;
    }
}
