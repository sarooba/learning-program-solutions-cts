package com.company.search;

public class Item {
    private int itemId;
    private String itemName;
    private String category;

    public Item(int itemId, String itemName, String category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "%d | %-20s | %s".formatted(itemId, itemName, category);
    }
}
