package com.company.search;

import java.util.Arrays;
import java.util.Comparator;

public class ItemSearchEngine {

    public static Item linearSearch(Item[] items, String targetName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(targetName)) {
                return item;
            }
        }
        return null;
    }

    public static Item binarySearch(Item[] items, String targetName) {
        int low = 0, high = items.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = items[mid].getItemName().compareToIgnoreCase(targetName);

            if (cmp == 0) return items[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void sortItemsByName(Item[] items) {
        Arrays.sort(items, Comparator.comparing(Item::getItemName, String.CASE_INSENSITIVE_ORDER));
    }
}
