package org.platform.exception.userExceptions;

import org.platform.exception.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
