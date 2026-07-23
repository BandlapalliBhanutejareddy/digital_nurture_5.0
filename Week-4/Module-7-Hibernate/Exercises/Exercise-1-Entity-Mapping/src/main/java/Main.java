package com.example;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Ravi", "CS");
        System.out.println("Mapped student entity:");
        System.out.println(student);
    }

    static final class Student {
        private final int id;
        private final String name;
        private final String department;

        Student(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', department='" + department + "'}";
        }
    }
}
