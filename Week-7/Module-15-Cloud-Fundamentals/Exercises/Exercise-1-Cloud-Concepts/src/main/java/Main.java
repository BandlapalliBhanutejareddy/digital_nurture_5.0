package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CloudConcepts concepts = new CloudConcepts();
        System.out.println(concepts.services());
    }

    static final class CloudConcepts {
        List<String> services() {
            return List.of("compute", "storage", "database", "networking");
        }
    }
}
