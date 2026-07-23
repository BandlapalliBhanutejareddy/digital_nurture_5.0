package com.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ComputeService service = new ComputeService();
        System.out.println(service.launch(Map.of("region", "us-east-1", "size", "small")));
    }

    static final class ComputeService {
        String launch(Map<String, String> config) {
            return "Launching compute instance in " + config.get("region") + " with size " + config.get("size");
        }
    }
}
