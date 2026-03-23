package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.dto.RouteRequest;
import com.p0znyaks.by_railway.dto.RouteResponse;
import com.p0znyaks.by_railway.entity.Route;
import com.p0znyaks.by_railway.entity.Station;
import com.p0znyaks.by_railway.entity.Train;
import com.p0znyaks.by_railway.exception.RouteNotFoundException;
import com.p0znyaks.by_railway.exception.StationNotFoundException;
import com.p0znyaks.by_railway.exception.TrainNotFoundException;
import com.p0znyaks.by_railway.repository.RouteRepository;
import com.p0znyaks.by_railway.repository.StationRepository;
import com.p0znyaks.by_railway.repository.TrainRepository;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final StationRepository stationRepository;
    private final TrainRepository trainRepository;

    @Transactional(readOnly = true)
    public List<RouteResponse> findAll() {
        return routeRepository.findAll().stream().map(RouteResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public RouteResponse findById(Long id) {
        return routeRepository
                .findById(id)
                .map(RouteResponse::from)
                .orElseThrow(() -> new RouteNotFoundException(id));
    }

    @Transactional
    public RouteResponse save(RouteRequest request) {
        Train train =
                trainRepository
                        .findById(request.trainId())
                        .orElseThrow(() -> new TrainNotFoundException(request.trainId()));
        Station departureStation =
                stationRepository
                        .findById(request.departureStationId())
                        .orElseThrow(
                                () -> new StationNotFoundException(request.departureStationId()));
        Station arrivalStation =
                stationRepository
                        .findById(request.arrivalStationId())
                        .orElseThrow(
                                () -> new StationNotFoundException(request.arrivalStationId()));
        Route route =
                Route.builder()
                        .train(train)
                        .departureStation(departureStation)
                        .arrivalStation(arrivalStation)
                        .departureTime(request.departureTime())
                        .arrivalTime(request.arrivalTime())
                        .price(request.price())
                        .build();
        return RouteResponse.from(routeRepository.save(route));
    }

    @Transactional
    public void delete(Long id) {
        Route route =
                routeRepository.findById(id).orElseThrow(() -> new RouteNotFoundException(id));
        routeRepository.delete(route);
    }

    @Transactional(readOnly = true)
    public List<RouteResponse> findAvailableRoutes(
            Long departureStationId, Long arrivalStationId, OffsetDateTime time) {
        Station departureStation =
                stationRepository
                        .findById(departureStationId)
                        .orElseThrow(() -> new StationNotFoundException(departureStationId));
        Station arrivalStation =
                stationRepository
                        .findById(arrivalStationId)
                        .orElseThrow(() -> new StationNotFoundException(arrivalStationId));
        return routeRepository.findAvailableRoutes(departureStation, arrivalStation, time).stream()
                .map(RouteResponse::from)
                .toList();
    }
}
