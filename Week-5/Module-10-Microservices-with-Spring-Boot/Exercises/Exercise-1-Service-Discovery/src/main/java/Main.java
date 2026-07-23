package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ServiceRegistry registry = new ServiceRegistry();
        registry.register("product-service", "http://localhost:8081");
        registry.register("order-service", "http://localhost:8082");

        System.out.println("Discovery result: " + registry.find("product-service"));
    }

    static final class ServiceRegistry {
        private final Map<String, String> services = new HashMap<>();

        void register(String name, String url) {
            services.put(name, url);
        }

        String find(String name) {
            return services.getOrDefault(name, "SERVICE_NOT_FOUND");
        }
    }
}
