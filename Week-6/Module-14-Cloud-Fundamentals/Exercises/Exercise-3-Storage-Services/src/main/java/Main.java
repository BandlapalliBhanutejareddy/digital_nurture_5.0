package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StorageService service = new StorageService();
        System.out.println(service.buckets());
    }

    static final class StorageService {
        List<String> buckets() {
            return List.of("logs-bucket", "images-bucket", "backups-bucket");
        }
    }
}
