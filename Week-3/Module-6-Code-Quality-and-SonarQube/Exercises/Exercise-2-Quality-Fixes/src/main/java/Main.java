package com.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] names = {"  alice  ", "bob", "  charlie  ", "alice", "  david  "};
        UniqueNameSorter sorter = new UniqueNameSorter(names);

        List<String> uniqueNames = sorter.uniqueNames();
        System.out.println("Sorted names: " + uniqueNames);
    }

    static final class UniqueNameSorter {
        private final String[] names;

        UniqueNameSorter(String[] names) {
            this.names = names;
        }

        List<String> uniqueNames() {
            return Arrays.stream(names)
                    .map(String::trim)
                    .distinct()
                    .sorted()
                    .toList();
        }
    }
}
