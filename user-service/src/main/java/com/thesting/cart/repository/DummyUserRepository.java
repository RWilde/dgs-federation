package com.thesting.cart.repository;

import com.netflix.dgs.codgen.generated.types.User;

import java.util.List;

public class DummyUserRepository {

    List<User> users = List.of(new User("1", "rebecca"), new User("2", "example"));

    public List<User> findAll() {
        return users;
    }

    public User findById(String userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst().get();
    }

    public User save(User user) {
        users.add(user);
        return user;
    }
}
