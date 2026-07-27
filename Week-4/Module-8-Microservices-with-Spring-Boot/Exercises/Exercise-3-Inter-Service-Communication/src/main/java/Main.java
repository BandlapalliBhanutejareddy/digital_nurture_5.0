package com.example;

public class Main {
    public static void main(String[] args) {
        OrderClient client = new OrderClient();
        System.out.println(client.getOrderStatus(1001));
    }

    static final class OrderClient {
        String getOrderStatus(int orderId) {
            return "Order " + orderId + " status: SHIPPED";
        }
    }
}
