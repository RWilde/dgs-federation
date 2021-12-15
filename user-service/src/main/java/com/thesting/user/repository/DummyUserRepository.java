package com.thesting.user.repository;

import com.thesting.user.exception.UserNotFoundError;
import com.thesting.user.types.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DummyUserRepository {

    List<User> users = List.of(new User(UUID.fromString("a18c0991-eb8f-319a-84bf-57d48cbd543c"), "rebecca"), new User(UUID.randomUUID(), "example"));

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(UUID userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();

    }

    public User save(User user) {
        users.add(user);
        return user;
    }
}
