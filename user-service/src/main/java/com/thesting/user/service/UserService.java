package com.thesting.user.service;

import com.thesting.user.exception.UserNotFoundError;
import com.thesting.user.types.User;

import java.util.List;

public interface UserService {
    User findById(String id) throws UserNotFoundError;

    List<User> findAll();

    User save(User user);
}
