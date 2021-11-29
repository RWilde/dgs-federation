package com.thesting.cart.fetchers;

import com.netflix.dgs.codgen.generated.types.Cart;
import com.netflix.dgs.codgen.generated.types.User;
import com.netflix.graphql.dgs.*;
import com.thesting.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@DgsComponent
public class CartDataFetcher {

    @Autowired
    CartService cartService;

    @DgsQuery
    public Cart cart(String id) {
        return cartService.findById(id);
    }

    @DgsQuery
    public User getUser() {
        return null;
    }

    @DgsQuery
    public List<Cart> carts(@RequestHeader String token) {

        return cartService.findAll(token);
    }

    @DgsEntityFetcher(name = "User")
    public User user(Map<String, Object> values) {
        String id = (String) values.get("id");

        return new User(id, cartService.findAllByUserId(id));
    }


    @DgsMutation
    public Cart createCart(@RequestHeader String token, @InputArgument("cart") Cart inputCart) {
        return cartService.save(inputCart, token);
    }

    @DgsMutation
    public void deleteCart(@RequestHeader String token, @InputArgument("cartId") String cartId) {
        cartService.deleteCart(cartId, token);
    }

    @DgsMutation
    public Cart updateCart(@RequestHeader String token, @InputArgument("cart") Cart updateCart) {
        return cartService.update(updateCart, token);
    }
}
