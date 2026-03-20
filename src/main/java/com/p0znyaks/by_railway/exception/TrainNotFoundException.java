package com.p0znyaks.by_railway.exception;

public class TrainNotFoundException extends ResourceNotFoundException {
    public TrainNotFoundException(Long id) {
        super("Train not found with id: " + id);
    }
}