package com.thesting.user.fetchers;

import com.netflix.graphql.dgs.*;
import com.thesting.user.exception.UserNotFoundError;
import com.thesting.user.service.UserService;
import com.thesting.user.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.UUID;

@DgsComponent
public class UserDataFetcher {

    @Autowired
    UserService userService;

    @DgsQuery
    public User user(@RequestHeader String token) throws UserNotFoundError {
        return userService.findById(token);
    }

    @DgsQuery
    public List<User> users(DgsDataFetchingEnvironment dataFetchingEnvironment) {
//        return getToken(dataFetchingEnvironment) != null ? List.of(userService.findById(getToken(dataFetchingEnvironment))) : userService.findAll();
        return userService.findAll();
    }

    @DgsMutation
    public User createUser(@InputArgument("username") String input) {
        return userService.save(new User(UUID.randomUUID(), input));
    }

    private String getToken(DgsDataFetchingEnvironment dataFetchingEnvironment) {
        var arg = dataFetchingEnvironment.getArguments();
        return arg.get("token").toString();
    }
}
