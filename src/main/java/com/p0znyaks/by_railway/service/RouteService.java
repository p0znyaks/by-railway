package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.entity.Route;
import com.p0znyaks.by_railway.entity.Station;
import com.p0znyaks.by_railway.exception.RouteNotFoundException;
import com.p0znyaks.by_railway.exception.StationNotFoundException;
import com.p0znyaks.by_railway.repository.RouteRepository;
import com.p0znyaks.by_railway.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final StationRepository stationRepository;

    @Transactional(readOnly = true)
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Route findById(Long id) {
        return routeRepository.findById(id).orElseThrow(()-> new RouteNotFoundException(id));
    }

    @Transactional
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @Transactional
    public void delete(Long id) {
        Route route = routeRepository.findById(id).orElseThrow(() -> new RouteNotFoundException(id));
        routeRepository.delete(route);
    }

    @Transactional(readOnly = true)
    public List<Route> findAvailableRoutes(Long departureStationId, Long arrivalStationId, OffsetDateTime time) {
        Station departureStation = stationRepository.findById(departureStationId).orElseThrow(() -> new StationNotFoundException(departureStationId));
        Station arrivalStation = stationRepository.findById(arrivalStationId).orElseThrow(() -> new StationNotFoundException(arrivalStationId));
        return routeRepository.findAvailableRoutes(departureStation, arrivalStation, time);
    }
}
