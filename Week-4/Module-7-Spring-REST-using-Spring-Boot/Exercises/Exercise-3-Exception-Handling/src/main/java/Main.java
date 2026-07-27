package com.example;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        try {
            service.processPayment(0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Handled exception: " + ex.getMessage());
        }
    }

    static final class PaymentService {
        void processPayment(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Payment amount must be greater than zero.");
            }
            System.out.println("Payment processed successfully for amount: " + amount);
        }
    }
}
