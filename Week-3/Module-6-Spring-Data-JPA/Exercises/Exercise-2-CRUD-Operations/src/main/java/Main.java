package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        repository.create(new Student(1, "Asha", "ECE"));
        repository.create(new Student(2, "Mehul", "IT"));

        System.out.println("Read student:");
        System.out.println(repository.read(1));

        repository.update(new Student(2, "Mehul Kumar", "CSE"));
        System.out.println("Updated student:");
        System.out.println(repository.read(2));

        repository.delete(1);
        System.out.println("Remaining students: " + repository.count());
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

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', department='" + department + "'}";
        }
    }

    static final class StudentRepository {
        private final Map<Integer, Student> store = new HashMap<>();

        void create(Student student) {
            store.put(student.getId(), student);
        }

        Student read(int id) {
            return store.get(id);
        }

        void update(Student student) {
            store.put(student.getId(), student);
        }

        void delete(int id) {
            store.remove(id);
        }

        int count() {
            return store.size();
        }
    }
}
