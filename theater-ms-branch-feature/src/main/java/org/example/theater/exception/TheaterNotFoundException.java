package org.example.theater.exception;

public class TheaterNotFoundException extends RuntimeException {
    public TheaterNotFoundException(int id) {
        super("Theater not found with id: " + id);
    }

}