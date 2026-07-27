package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        service.addProduct(new Product(1, "Mouse", 29.99));
        service.addProduct(new Product(2, "Keyboard", 79.99));

        System.out.println("All products in stock:");
        service.getProducts().forEach(System.out::println);
        System.out.println("Total inventory value: " + service.getTotalPrice());
    }

    static final class Product {
        private final int id;
        private final String name;
        private final double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
        }
    }

    static final class ProductService {
        private final List<Product> products = new ArrayList<>();

        void addProduct(Product product) {
            if (product.getPrice() <= 0) {
                throw new IllegalArgumentException("Price must be greater than zero");
            }
            products.add(product);
        }

        List<Product> getProducts() {
            return products;
        }

        double getTotalPrice() {
            return products.stream().mapToDouble(Product::getPrice).sum();
        }
    }
}
