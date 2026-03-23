package com.p0znyaks.by_railway.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

// FIXME: arrivalTime больше чем departureTime должен быть обязательно. пока оставляю @Future на
// обоих, что технически правильно (не всегда)
public record RouteRequest(
        @NotNull Long trainId,
        @NotNull Long departureStationId,
        @NotNull Long arrivalStationId,
        @NotNull @Future OffsetDateTime departureTime,
        @NotNull @Future OffsetDateTime arrivalTime,
        @NotNull @Positive BigDecimal price) {}
