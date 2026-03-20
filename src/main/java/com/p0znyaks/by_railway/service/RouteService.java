package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.repository.RouteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
}
