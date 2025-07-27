package com.company.search;

public class ECommerceSearchDemo {
    public static void main(String[] args) {
        Item[] items = {
            new Item(101, "Laptop", "Electronics"),
            new Item(102, "Mouse", "Accessories"),
            new Item(103, "Keyboard", "Accessories"),
            new Item(104, "Monitor", "Electronics"),
            new Item(105, "Phone", "Mobiles")
        };

        Item result1 = ItemSearchEngine.linearSearch(items, "Keyboard");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not found"));

        ItemSearchEngine.sortItemsByName(items);

        Item result2 = ItemSearchEngine.binarySearch(items, "Keyboard");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not found"));
    }
}
