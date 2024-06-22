package org.platform.exception.userExceptions;

import org.platform.exception.ValidationException;

public class UserValidationException extends ValidationException {
    public UserValidationException(String errorMassage) {
        super(errorMassage);
    }
}
