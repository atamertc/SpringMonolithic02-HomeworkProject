package com.atamertc.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final EErrorType type;

    public UserNotFoundException(EErrorType type) {
        super(type.getMessage());
        this.type = type;
    }

    public UserNotFoundException(EErrorType type, String message) {
        super(type.getMessage());
        this.type = type;
    }
}
