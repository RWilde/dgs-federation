package com.thesting.product.service;


import com.netflix.dgs.codgen.generated.types.Product;

import java.util.List;

public interface ProductService {
    Product findById(String id);

    List<Product> findAll();

    List<Product> loadAll(List<String> keys);
}
