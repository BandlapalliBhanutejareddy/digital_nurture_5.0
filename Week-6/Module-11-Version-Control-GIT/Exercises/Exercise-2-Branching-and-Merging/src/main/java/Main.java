package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BranchPractice practice = new BranchPractice();
        System.out.println(practice.steps());
    }

    static final class BranchPractice {
        List<String> steps() {
            return List.of(
                    "git checkout -b feature/login",
                    "git add .",
                    "git commit -m \"Add login changes\"",
                    "git checkout main",
                    "git merge feature/login"
            );
        }
    }
}
