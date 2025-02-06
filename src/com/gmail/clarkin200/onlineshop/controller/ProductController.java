package com.gmail.clarkin200.onlineshop.controller;

import com.gmail.clarkin200.onlineshop.models.Product;
import com.gmail.clarkin200.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
@Qualifier("productController")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void createProduct(String name, float price) {
        Product newProduct = productService.createProduct(new Product(name, price));
        System.out.println("New product " + newProduct + " created");


    }

    public void getAllProductFromShop() {
        if (productService.getAllProductFromShop().isPresent()) {
            productService.getAllProductFromShop().get().forEach(System.out::println);
        } else {
            System.out.println("Shop is null or empty");
        }
    }

    public void getByIdFromShop(Long id) {
        if (productService.getByIdFromShop(id).isPresent()) {
            System.out.println(productService.getByIdFromShop(id));
        } else {
            System.out.println("Product with id " + id + " not found");
        }
    }

    public void deleteByIdFromShop(Long id) {
        if (productService.deleteByIdFromShop(id)) {
            System.out.println("Product with id: " + id + " deleted");
        } else {
            System.out.println("Product with id: " + id + "don't deleted");
        }
    }

    public void updateProductById(Long id,String name,float price) {
        if(productService.getByIdFromShop(id).isPresent()){
            Product productToUpdate = productService.getByIdFromShop(id).get();
            productToUpdate.setName(name);
            productToUpdate.setPrice(price);
        }
        else{
            System.out.println("Product with id: " + id + "not found");
        }
    }
}
