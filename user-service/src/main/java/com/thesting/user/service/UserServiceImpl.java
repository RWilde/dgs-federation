package com.thesting.user.service;

import com.thesting.user.exception.UserNotFoundError;
import com.thesting.user.repository.DummyUserRepository;
import com.thesting.user.types.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

    DummyUserRepository userRepository = new DummyUserRepository();

    public User findById(String id) throws UserNotFoundError {
        return userRepository.findById(UUID.fromString(id)).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
