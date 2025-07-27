package com.company.inventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class Inventory {
    private final Map<Integer, Product> products = new HashMap<>(16_384);

    public void add(Product p) {
        products.put(p.getProductId(), p);
    }

    public boolean update(int id, Consumer<Product> updater) {
        Product p = products.get(id);
        if (p == null) return false;
        updater.accept(p);
        return true;
    }

    public Product delete(int id) {
        return products.remove(id);
    }

    public Optional<Product> find(int id) {
        return Optional.ofNullable(products.get(id));
    }

    public Collection<Product> all() {
        return products.values();
    }
}
