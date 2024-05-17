package org.example.location.exception;

public class DuplicateLocationFound extends RuntimeException {
    public DuplicateLocationFound(int id) {
        super("Duplicate location found for id: " + id);
    }

}