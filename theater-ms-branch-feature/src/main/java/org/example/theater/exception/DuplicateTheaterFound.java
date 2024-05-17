package org.example.theater.exception;

public class DuplicateTheaterFound extends RuntimeException {
    public DuplicateTheaterFound(int id) {
        super("Duplicate location found for id: " + id);
    }

}