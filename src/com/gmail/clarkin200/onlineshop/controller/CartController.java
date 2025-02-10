package com.gmail.clarkin200.onlineshop.controller;

import com.gmail.clarkin200.onlineshop.service.CartService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Qualifier("cartController")
@Scope("prototype")
public class CartController {
    CartService cartService;

    public CartController(@Qualifier("cartService") CartService cartService) {
        this.cartService = cartService;
    }

    public void addProductToCartById(Long id) {
        if (cartService.addProductToCartById(id)) {
            System.out.println("Product with id: " + id + " added to cart");
        } else {
            System.out.println("Error product with id: " + id + " don't added to cart");
        }
    }

    public void deleteProductFromCartById(Long id) {
        if (cartService.deleteProductFromCartById(id)) {
            System.out.println("Product with id: " + id + " deleted from cart");
        } else {
            System.out.println("Error product with id: " + id + " don't deleted from cart");
        }
    }

    public void showCart(){
        if(cartService.showProductInCart().isPresent()){
            cartService.showProductInCart().get().forEach(System.out::println);
        }else{
            System.out.println("Cart is null or empty");
        }
    }
}
