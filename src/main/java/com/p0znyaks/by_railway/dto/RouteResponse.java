package com.p0znyaks.by_railway.dto;

import com.p0znyaks.by_railway.entity.Route;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record RouteResponse(Long id, TrainResponse train, StationResponse departureStation, StationResponse arrivalStation,
                            OffsetDateTime departureTime, OffsetDateTime arrivalTime, BigDecimal price) {
    public static RouteResponse from(Route route) {
        return new RouteResponse(
                route.getId(),
                TrainResponse.from(route.getTrain()),
                StationResponse.from(route.getDepartureStation()),
                StationResponse.from(route.getArrivalStation()),
                route.getDepartureTime(),
                route.getArrivalTime(),
                route.getPrice()
        );
    }
}
