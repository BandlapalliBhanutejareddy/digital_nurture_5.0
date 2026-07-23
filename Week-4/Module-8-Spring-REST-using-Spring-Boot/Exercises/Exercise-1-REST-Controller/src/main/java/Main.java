package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        controller.addCustomer(new Customer(1, "Nisha"));
        controller.addCustomer(new Customer(2, "Raj"));

        System.out.println("Customers returned by controller:");
        controller.getCustomers().forEach(System.out::println);
    }

    static final class Customer {
        private final int id;
        private final String name;

        Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Customer{id=" + id + ", name='" + name + "'}";
        }
    }

    static final class CustomerController {
        private final List<Customer> customers = new ArrayList<>();

        void addCustomer(Customer customer) {
            customers.add(customer);
        }

        List<Customer> getCustomers() {
            return customers;
        }
    }
}
