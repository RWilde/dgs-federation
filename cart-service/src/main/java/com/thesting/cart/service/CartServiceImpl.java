package com.thesting.cart.service;

import com.netflix.dgs.codgen.generated.types.Cart;
import com.netflix.dgs.codgen.generated.types.Product;
import com.thesting.cart.repository.DummyCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    DummyCartRepository carts = new DummyCartRepository();

    @Override
    public Cart update(Cart cart, String userId) {
        carts.save(cart, userId);
        return cart;
    }

    @Override
    public Cart mergeCarts(String mainCartId, String toMergeCartId, String userId) {
        Cart main = carts.findById(mainCartId);
        Cart toBeDeleted = carts.findById(toMergeCartId);

        main.getItems().addAll(toBeDeleted.getItems());

        carts.save(main, userId);
        carts.deleteCart(toMergeCartId, userId);
        return update(main, userId);
    }

    @Override
    public Cart splitCart(String newCartId, String oldCartId, List<Product> itemSubList, String userId) {
        Cart newCart = carts.findById(newCartId);
        Cart oldCart = carts.findById(oldCartId);

        newCart.getItems().addAll(itemSubList);
        oldCart.getItems().removeAll(itemSubList);

        update(oldCart, userId);
        return update(newCart, userId);
    }

    @Override
    public String serialise(Cart cart) {
        return null;
    }

    @Override
    public Cart deserialise(String cart) {
        return null;
    }

    @Override
    public Cart copy(String cartId, String userId) {
        Cart cart = carts.findById(cartId);
        cart.setId(null);

        return save(cart, userId);
    }

    @Override
    public Cart findById(String id) {
        return carts.findById(id);
    }

    @Override
    public List<Cart> findAllByUserId(String id) {
        return carts.findAllByUserId(id);
    }

    public Cart save(Cart cart, String userId) {
        carts.save(cart, userId);
        return cart;
    }

    public void deleteCart(String cartId, String userId) {
        carts.deleteCart(cartId, userId);
    }

    @Override
    public List<Cart> findAll(String userId) {
        return carts.findAll(userId);
    }


}
