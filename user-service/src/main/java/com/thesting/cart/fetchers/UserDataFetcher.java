package com.thesting.cart.fetchers;

import com.netflix.dgs.codgen.generated.types.User;
import com.netflix.graphql.dgs.*;
import com.thesting.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@DgsComponent
public class UserDataFetcher {

    @Autowired
    UserService userService;

    @DgsQuery
    public User user(@RequestHeader String token) {
        return userService.findById(token);
    }

    @DgsQuery
    public List<User> users(DgsDataFetchingEnvironment dataFetchingEnvironment) {
//        return getToken(dataFetchingEnvironment) != null ? List.of(userService.findById(getToken(dataFetchingEnvironment))) : userService.findAll();
        return userService.findAll();
    }

    @DgsMutation
    public User createUser(@InputArgument("username") String input) {
        return userService.save(new User(Integer.toString(userService.findAll().size()), input));
    }

    private String getToken(DgsDataFetchingEnvironment dataFetchingEnvironment) {
        var arg = dataFetchingEnvironment.getArguments();
        return arg.get("token").toString();
    }
}
