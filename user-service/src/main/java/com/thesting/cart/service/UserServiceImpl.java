package com.thesting.cart.service;

import com.netflix.dgs.codgen.generated.types.User;
import com.thesting.cart.repository.DummyUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    DummyUserRepository userRepository = new DummyUserRepository();

    public User findById(String id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
