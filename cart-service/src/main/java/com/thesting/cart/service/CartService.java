package com.thesting.cart.service;

import com.netflix.dgs.codgen.generated.types.Cart;
import com.netflix.dgs.codgen.generated.types.Product;

import java.util.List;

public interface CartService {
    Cart findById(String id);

    List<Cart> findAllByUserId(String id);

    Cart save(Cart cart, String userId);

    void deleteCart(String cartId, String userId);

    List<Cart> findAll(String userId);

    Cart update(Cart cart, String userId);

    Cart mergeCarts(String mainCartId, String toMergeCartId, String userId);

    Cart splitCart(String newCartId, String oldCartId, List<Product> itemSubList, String userId);

    String serialise(Cart cart);

    Cart deserialise(String cart);

    Cart copy(String cartId, String userId);
}
