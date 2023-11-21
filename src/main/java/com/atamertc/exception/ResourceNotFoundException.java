package com.atamertc.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final EErrorType type;

    public ResourceNotFoundException(EErrorType type) {
        super(type.getMessage());
        this.type = type;
    }

    public ResourceNotFoundException(EErrorType type, String message) {
        super(type.getMessage());
        this.type = type;
    }
}
