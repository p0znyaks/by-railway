package com.p0znyaks.by_railway.exception;

public class StationNotFoundException extends ResourceNotFoundException {
    public StationNotFoundException(Long id) {
        super("Station not found with id: " + id);
    }
}
