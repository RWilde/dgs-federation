package com.thesting.product.repository;

import com.netflix.dgs.codgen.generated.types.Product;

import java.util.List;

public class DummyProductRepository {

    List<Product> products = List.of(new Product("sku123", "tshirt", "very nice tshirt"), new Product("sku124", "jeans", "very nice jeans"), new Product("sku125", "top", "very nice top"), new Product("sku126", "hat", "very nice hat"));

    public List<Product> findAll() {
        return products;
    }

    public Product findById(String userId) {
        return products.stream().filter(user -> user.getSku().equals(userId)).findFirst().get();
    }
}
