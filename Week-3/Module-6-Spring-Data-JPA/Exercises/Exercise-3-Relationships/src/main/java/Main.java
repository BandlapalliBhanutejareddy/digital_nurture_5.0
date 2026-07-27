package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(1, "Hibernate Relationships");
        course.addStudent(new Student(101, "Asha"));
        course.addStudent(new Student(102, "Rahul"));
        course.addStudent(new Student(103, "Priya"));

        System.out.println("Course: " + course.getTitle());
        course.getStudents().forEach(student -> System.out.println("Student: " + student.getName()));
    }

    static final class Course {
        private final int id;
        private final String title;
        private final List<Student> students = new ArrayList<>();

        Course(int id, String title) {
            this.id = id;
            this.title = title;
        }

        void addStudent(Student student) {
            students.add(student);
        }

        List<Student> getStudents() {
            return students;
        }

        String getTitle() {
            return title;
        }
    }

    static final class Student {
        private final int id;
        private final String name;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        String getName() {
            return name;
        }
    }
}
