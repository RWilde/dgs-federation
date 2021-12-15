package com.thesting.product.loaders;

import com.netflix.dgs.codgen.generated.types.Product;
import com.netflix.graphql.dgs.DgsDataLoader;
import com.thesting.product.service.ProductService;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "productLoader")
public class ProductDataLoader implements BatchLoader<String, Product> {

    @Autowired
    ProductService productService;

    @Override
    public CompletionStage<List<Product>> load(List<String> keys) {
        return CompletableFuture.supplyAsync(() -> productService.loadAll(keys));
    }
}
