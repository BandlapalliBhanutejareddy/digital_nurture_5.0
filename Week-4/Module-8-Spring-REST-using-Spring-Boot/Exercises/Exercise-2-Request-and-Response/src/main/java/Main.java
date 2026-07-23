package com.example;

public class Main {
    public static void main(String[] args) {
        OrderRequest request = new OrderRequest(2, "Laptop", 1299.99);
        OrderResponse response = OrderMapper.toResponse(request);
        System.out.println(response);
    }

    static final class OrderRequest {
        private final int quantity;
        private final String productName;
        private final double price;

        OrderRequest(int quantity, String productName, double price) {
            this.quantity = quantity;
            this.productName = productName;
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }
    }

    static final class OrderResponse {
        private final String productName;
        private final int quantity;
        private final double total;

        OrderResponse(String productName, int quantity, double total) {
            this.productName = productName;
            this.quantity = quantity;
            this.total = total;
        }

        @Override
        public String toString() {
            return "OrderResponse{productName='" + productName + "', quantity=" + quantity + ", total=" + total + "}";
        }
    }

    static final class OrderMapper {
        static OrderResponse toResponse(OrderRequest request) {
            double total = request.getQuantity() * request.getPrice();
            return new OrderResponse(request.getProductName(), request.getQuantity(), total);
        }
    }
}
