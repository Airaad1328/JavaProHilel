package com.gmail.clarkin200.onlineshop.repository;

import com.gmail.clarkin200.onlineshop.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("cartRepository")
@Scope("prototype")
public class CartRepositoryImpl implements CartRepository<Long,Product>{

    private final List<Product> repository = new ArrayList<>();


    @Override
    public boolean addProduct(Product entity) {
        repository.add(entity);
        return true;
    }

    @Override
    public boolean deleteProductById(Long id) {
        repository.removeIf(product -> product.getId() == id);
        return true;
    }

    @Override
    public Optional<List<Product>> showAll() {
        return Optional.of(repository);
    }
}
