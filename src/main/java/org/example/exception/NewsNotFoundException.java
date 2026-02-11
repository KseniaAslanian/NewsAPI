package org.example.exception;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException(Long id) {
        super("News with id " + id + " is not found");
    }
}
