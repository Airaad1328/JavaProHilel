package com.gmail.clarkin200.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 801.03),
                new Product("TV", "Electronics", 1500.11),
                new Product("Banana", "Groceries", 1.20),
                new Product("Apple", "Groceries", 1.50),
                new Product("Bread", "Groceries", 2.02),
                new Product("T-shirt", "Clothing", 20.00),
                new Product("Jeans", "Clothing", 40.40)
        );

        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(groupingBy(Product::getCategory));

        System.out.println("Продукти за категоріями:");

        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("\nСередня ціна за категоріями:");

        averagePriceByCategory.forEach((category, avgPrice) -> {
            System.out.printf("%s: %.2f%n", category, avgPrice);
        });

        Optional<Map.Entry<String, Double>> maxAvgPriceCategory = averagePriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxAvgPriceCategory.ifPresent(entry -> {
            System.out.printf("\nКатегорія з найвищою середньою ціною: %s (%.2f)%n",
                    entry.getKey(), entry.getValue());
        });
    }
}
