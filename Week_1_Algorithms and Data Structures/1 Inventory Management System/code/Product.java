package com.company.inventory;

public class Product {
    private final int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public void setProductName(String name) { this.productName = name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "%d | %-25s | %4d | %.2f".formatted(productId, productName, quantity, price);
    }
}
