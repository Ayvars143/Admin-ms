package org.example.screenms.exception;

public class DuplicateScreenFound extends RuntimeException {

    public DuplicateScreenFound(int id) {
        super("Duplicate Screen found for id: " + id);
    }
}
