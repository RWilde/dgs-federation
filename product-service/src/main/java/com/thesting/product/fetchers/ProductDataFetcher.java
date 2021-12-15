package com.thesting.product.fetchers;

import com.netflix.dgs.codgen.generated.types.Product;
import com.netflix.graphql.dgs.*;
import com.thesting.product.service.ProductService;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class ProductDataFetcher {

    @Autowired
    ProductService productService;

    @DgsQuery
    public Product product(@InputArgument("productId") String input) {
        return productService.findById(input);
    }

    @DgsEntityFetcher(name = "Product")
    public CompletableFuture<Product> items(Map<String, Object> values, DgsDataFetchingEnvironment dataFetchingEnvironment) {
        String id = (String) values.get("sku");
        DataLoader<String, Product> dataLoader = dataFetchingEnvironment.getDataLoader("productLoader");
        return dataLoader.load(id);
    }

}
