package com.thesting.cart.service;


import com.netflix.dgs.codgen.generated.types.User;

import java.util.List;

public interface UserService {
    User findById(String id);

    List<User> findAll();

    User save(User user);
}
