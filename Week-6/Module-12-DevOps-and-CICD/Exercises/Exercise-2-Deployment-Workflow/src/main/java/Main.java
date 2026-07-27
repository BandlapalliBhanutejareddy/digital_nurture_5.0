package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeploymentChecklist checklist = new DeploymentChecklist();
        System.out.println(checklist.steps());
    }

    static final class DeploymentChecklist {
        List<String> steps() {
            return List.of(
                    "build application",
                    "run tests",
                    "package artifact",
                    "deploy to target environment"
            );
        }
    }
}
