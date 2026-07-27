package com.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApiGateway gateway = new ApiGateway();
        System.out.println(gateway.route("/products"));
        System.out.println(gateway.route("/orders"));
    }

    static final class ApiGateway {
        private final Map<String, String> routes = Map.of(
                "/products", "product-service",
                "/orders", "order-service"
        );

        String route(String path) {
            return routes.getOrDefault(path, "No route configured");
        }
    }
}
