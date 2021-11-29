package com.thesting.cart.repository;

import com.google.gson.Gson;
import com.netflix.dgs.codgen.generated.types.Cart;
import com.netflix.dgs.codgen.generated.types.Item;
import com.netflix.dgs.codgen.generated.types.Product;
import com.netflix.dgs.codgen.generated.types.Purpose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DummyCartRepository {
    private final HashMap<String, ArrayList<Cart>> carts = new HashMap<String, ArrayList<Cart>>();
    private final Gson gson = new Gson();
    List<Product> items = List.of(new Product("sku123", 1), new Product("sku124", 2));

    public DummyCartRepository() {

        Cart.Builder cart = Cart.newBuilder();
        ArrayList<Cart> cartList = new ArrayList<>(Arrays.asList(cart.id("1").name("cart").purpose(Purpose.CART).items(items).build()));
        ArrayList<Cart> wishList = new ArrayList<>(Arrays.asList(cart.id("2").name("wishlist").purpose(Purpose.WISHLIST).items(items).build(), cart.name("cart").purpose(Purpose.CART).items(items).build()));

        carts.put("1", cartList);
        carts.put("2", wishList);
    }

    public Cart findById(String id) {
        return carts.values().stream().flatMap(carts1 -> carts1.stream().filter(cart -> cart.getId().equals(id))).findFirst().get();
    }

    public List<Cart> findAllByUserId(String id) {
        return carts.get(id);
    }

    public Cart save(Cart cart, String userId) {
        var userCarts = carts.get(userId);
        userCarts.add(cart);
        var returnedCard = carts.put(userId, userCarts);
        return cart;
    }

    public Boolean deleteCart(String cartId, String userId) {
        return carts.get(userId).removeIf(cart -> cart.getId().equals(cartId));
    }

    public List<Cart> findAll(String userId) {
        return carts.get(userId);
    }

    public Cart update(Cart cart) {
        return null;
    }

    public Cart mergeCarts(String mainCartId, String toMergeCartId) {
        return null;
    }

    public Cart splitCart(String newCartId, String oldCartId, List<Item> itemSubList) {
        return null;
    }

    public String serialise(Cart cart) {
        return null;
    }

    public Cart deserialise(String cart) {
        return null;
    }

    public Cart copy(String cartId) {
        return null;
    }

}
