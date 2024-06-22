package org.platform.exception;

public  abstract class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
