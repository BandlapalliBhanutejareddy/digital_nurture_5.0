package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PromptDesigner designer = new PromptDesigner();
        System.out.println(designer.elements());
    }

    static final class PromptDesigner {
        List<String> elements() {
            return List.of("role", "task", "context", "constraints", "output format");
        }
    }
}
