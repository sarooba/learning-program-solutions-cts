package com.company.inventory;

public class OrderSortDemo {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(201, "Alice", 350.00),
            new Order(202, "Bob", 125.50),
            new Order(203, "Charlie", 675.90),
            new Order(204, "Diana", 220.75),
            new Order(205, "Ethan", 150.00)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        OrderSorter.bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort (by totalPrice):");
        printOrders(orders);

        // Re-initialize for quick sort
        Order[] quickSortOrders = {
            new Order(201, "Alice", 350.00),
            new Order(202, "Bob", 125.50),
            new Order(203, "Charlie", 675.90),
            new Order(204, "Diana", 220.75),
            new Order(205, "Ethan", 150.00)
        };

        OrderSorter.quickSort(quickSortOrders, 0, quickSortOrders.length - 1);
        System.out.println("\nAfter Quick Sort (by totalPrice):");
        printOrders(quickSortOrders);
    }

    private static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
