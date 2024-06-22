package org.platform.exception.userExceptions;

import org.platform.exception.ResourceAlreadyExistsException;

public class UserAlreadyExistException extends ResourceAlreadyExistsException {
    public UserAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
