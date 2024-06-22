package org.platform.exception;

public abstract class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String errorMessage){
        super(errorMessage);
    }
}
