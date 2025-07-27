package com.company.inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.add(new Product(101, "USB-C Cable", 500, 1.99));
        inv.add(new Product(102, "27\" 4K Monitor", 30, 219.00));

        inv.update(101, p -> p.setQuantity(p.getQuantity() - 3));

        inv.find(101).ifPresent(System.out::println);

        inv.delete(102);

        System.out.println("Current SKUs: " + inv.all().size());
    }
}
