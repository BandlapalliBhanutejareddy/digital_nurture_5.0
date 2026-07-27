package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CiCdWorkflow workflow = new CiCdWorkflow();
        System.out.println(workflow.stages());
    }

    static final class CiCdWorkflow {
        List<String> stages() {
            return List.of(
                    "build",
                    "test",
                    "package",
                    "deploy"
            );
        }
    }
}
