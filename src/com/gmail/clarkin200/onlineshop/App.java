package com.gmail.clarkin200.onlineshop;


import com.gmail.clarkin200.onlineshop.config.AppConfig;
import com.gmail.clarkin200.onlineshop.controller.CartController;
import com.gmail.clarkin200.onlineshop.controller.ProductController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class App {

    private static final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(String[] args) {
        CartController cartController = context.getBean("cartController",CartController.class);
        ProductController productController = context.getBean("productController",ProductController.class);
        boolean isOn = true;
        Scanner scanner = new Scanner(System.in);

        while(isOn){
            System.out.println("Choose operation");
            System.out.println("1. Add product to cart");
            System.out.println("2. Remove product to cart");
            System.out.println("3. Show cart");
            System.out.println("4. Show product on shop");
            System.out.println("5. Add product to shop ");
            System.out.println("6. Delete product from shop by id");
            System.out.println("7. Update product from shop by id");
            System.out.println("0. Exit");

            int operation = scanner.nextInt();
            scanner.nextLine();

            switch (operation){
                case 1:
                    System.out.println("Enter product id to add");
                    Long idToAdd = scanner.nextLong();
                    scanner.nextLine();
                    cartController.addProductToCartById(idToAdd);
                    break;
                case 2:
                    System.out.println("Enter product id to remove");
                    Long idToRemove = scanner.nextLong();
                    scanner.nextLine();
                    cartController.deleteProductFromCartById(idToRemove);
                    break;
                case 3:
                    System.out.println("Products in cart:");
                    cartController.showCart();
                    break;
                case 4:
                    System.out.println("Products in shop");
                    productController.getAllProductFromShop();
                    break;
                case 5:
                    System.out.println("Enter product name");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product price");
                    float productPrice = scanner.nextFloat();
                    productController.createProduct(productName,productPrice);
                    break;
                case 6:
                    System.out.println("Enter id to delete");
                    Long toDelete = scanner.nextLong();
                    scanner.nextLine();
                    productController.deleteByIdFromShop(toDelete);
                    break;
                case 7:
                    System.out.println("Enter id to update");
                    Long toUpdate = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter new name product");
                    String newProductName = scanner.nextLine();
                    System.out.println("Enter new price");
                    float newProductPrice = scanner.nextFloat();
                    scanner.nextLine();
                    productController.updateProductById(toUpdate,newProductName,newProductPrice);
                    break;
                case 0:
                    isOn = false;
                    break;
            }
        }
    }
}
