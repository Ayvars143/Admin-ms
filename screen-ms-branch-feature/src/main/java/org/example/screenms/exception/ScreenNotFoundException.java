package org.example.screenms.exception;

public class ScreenNotFoundException extends RuntimeException {

    public ScreenNotFoundException(int id) {
        super("Screen not found with id: " + id);
    }
}
