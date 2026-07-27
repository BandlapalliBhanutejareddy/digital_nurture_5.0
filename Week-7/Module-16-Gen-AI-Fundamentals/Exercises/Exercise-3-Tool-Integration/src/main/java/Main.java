package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ToolPipeline pipeline = new ToolPipeline();
        System.out.println(pipeline.tools());
    }

    static final class ToolPipeline {
        List<String> tools() {
            return List.of("prompt", "model", "parser", "response handler");
        }
    }
}
