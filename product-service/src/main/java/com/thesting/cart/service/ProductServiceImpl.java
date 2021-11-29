package com.thesting.cart.service;

import com.netflix.dgs.codgen.generated.types.Product;
import com.thesting.cart.repository.DummyProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    DummyProductRepository productRepository = new DummyProductRepository();

    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> loadAll(List<String> keys) {
        return productRepository
                .findAll()
                .stream()
                .filter(entry -> keys.contains(entry.getSku())).collect(Collectors.toList());
    }


}
