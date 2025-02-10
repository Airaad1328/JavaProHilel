package com.gmail.clarkin200.onlineshop.service;

import com.gmail.clarkin200.onlineshop.models.Product;
import com.gmail.clarkin200.onlineshop.repository.CartRepository;
import com.gmail.clarkin200.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("cartService")
@Scope("prototype")
public class CartService {
    private final ProductRepository<Long,Product> productRepository;
    private final CartRepository<Long,Product> cartRepository;

    public CartService(@Qualifier("productRepository") ProductRepository productRepository,
                       @Qualifier("cartRepository") CartRepository cartRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public boolean addProductToCartById(Long id){
        if(productRepository.getById(id).isPresent()){
            return cartRepository.addProduct(productRepository.getById(id).get());
        }
        else{
            return false;
        }
    }

    public boolean deleteProductFromCartById(Long id){
        return cartRepository.deleteProductById(id);
    }

    public Optional<List<Product>> showProductInCart(){
        return cartRepository.showAll();
    }
}
