package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GitWorkflow workflow = new GitWorkflow();
        System.out.println(workflow.commands());
    }

    static final class GitWorkflow {
        List<String> commands() {
            return List.of(
                    "git init",
                    "git status",
                    "git add .",
                    "git commit -m \"initial commit\""
            );
        }
    }
}
