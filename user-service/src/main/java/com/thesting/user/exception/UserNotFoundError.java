package com.thesting.user.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.execution.ResultPath;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents error condition where an unauthorised user tries to access protected content
 */
public class UserNotFoundError extends Throwable {

    private static final String ERROR = "UNAUTHORIZED_ACCESS";

    private final String message;

    public UserNotFoundError(String userId) {
        this.message = "Exception while fetching data (" + userId + "): not found";
    }

    @Override
    public String getMessage() {
        return message;
    }

}
