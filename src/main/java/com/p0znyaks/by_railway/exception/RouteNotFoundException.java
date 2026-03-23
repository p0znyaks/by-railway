package com.p0znyaks.by_railway.exception;

public class RouteNotFoundException extends ResourceNotFoundException {
    public RouteNotFoundException(Long id) {
        super("Route not found with id: " + id);
    }
}
