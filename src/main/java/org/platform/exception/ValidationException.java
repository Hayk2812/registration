package org.platform.exception;

public abstract class ValidationException extends RuntimeException{
    public ValidationException(String errorMassage){
        super(errorMassage);
    }
}
