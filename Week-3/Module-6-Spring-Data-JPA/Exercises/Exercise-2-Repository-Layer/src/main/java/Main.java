package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        repository.save(new Product(1, "Phone", 699.00));
        repository.save(new Product(2, "Tablet", 499.00));

        System.out.println("Saved products:");
        repository.findAll().forEach(System.out::println);

        Product updated = new Product(1, "Phone Pro", 799.00);
        repository.update(updated);
        System.out.println("Updated product:");
        System.out.println(repository.findById(1));
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

    static final class ProductRepository {
        private final Map<Integer, Product> storage = new HashMap<>();

        void save(Product product) {
            storage.put(product.getId(), product);
        }

        void update(Product product) {
            storage.put(product.getId(), product);
        }

        Product findById(int id) {
            return storage.get(id);
        }

        java.util.List<Product> findAll() {
            return storage.values().stream().toList();
        }
    }
}
