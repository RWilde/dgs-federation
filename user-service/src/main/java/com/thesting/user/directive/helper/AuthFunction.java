package com.thesting.user.directive.helper;

import com.thesting.user.exception.UserNotFoundError;
import com.thesting.user.repository.DummyUserRepository;
import com.thesting.user.types.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component("authFunction")
public class AuthFunction {

    private DummyUserRepository userRepository;

    public AuthFunction(DummyUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validUserToken(String userUuid){
        try {
            return !userRepository.findById(UUID.fromString(userUuid)).isEmpty();
        } catch (Exception e){
            return false;
        }
    }
}
