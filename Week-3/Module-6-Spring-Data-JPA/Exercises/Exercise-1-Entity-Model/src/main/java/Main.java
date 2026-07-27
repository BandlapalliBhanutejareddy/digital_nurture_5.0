package com.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(101, "Laptop", 1299.99);
        System.out.println("Entity model snapshot:");
        System.out.println(product.toString());
    }

    static final class Product {
        private final int id;
        private final String name;
        private final double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = Objects.requireNonNull(name, "name must not be null");
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
        }
    }
}
