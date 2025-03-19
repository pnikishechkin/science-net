package ru.nikishechkin.sciencebook.exception;

public class AuthorizeException extends RuntimeException {
    public AuthorizeException(String message) {
        super(message);
    }
}
