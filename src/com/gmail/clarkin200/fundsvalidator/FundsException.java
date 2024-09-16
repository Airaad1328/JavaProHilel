package com.gmail.clarkin200.fundsvalidator;

public class FundsException extends RuntimeException {

    private final String message;

    public FundsException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
