package com.conscifora.lang.userservice.exception;

public class CreationException extends RuntimeException {

    private String message;

    public CreationException(String message) {
        super(message);
    }

}
