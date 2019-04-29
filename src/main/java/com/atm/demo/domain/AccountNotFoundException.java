package com.atm.demo.domain;

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
