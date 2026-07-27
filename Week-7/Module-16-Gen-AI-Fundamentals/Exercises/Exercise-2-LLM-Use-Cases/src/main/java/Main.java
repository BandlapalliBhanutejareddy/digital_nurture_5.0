package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UseCaseCatalog catalog = new UseCaseCatalog();
        System.out.println(catalog.useCases());
    }

    static final class UseCaseCatalog {
        List<String> useCases() {
            return List.of("summarization", "classification", "code generation", "chat assistance");
        }
    }
}
