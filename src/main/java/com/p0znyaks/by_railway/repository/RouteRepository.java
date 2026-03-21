package com.p0znyaks.by_railway.repository;

import com.p0znyaks.by_railway.entity.Route;
import com.p0znyaks.by_railway.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("SELECT r FROM Route r JOIN FETCH r.train JOIN FETCH r.departureStation JOIN FETCH r.arrivalStation WHERE r.departureStation = :from AND r.arrivalStation = :to AND r.departureTime >= :time")
    List<Route> findAvailableRoutes(@Param("from") Station from, @Param("to") Station to,
                                    @Param("time") OffsetDateTime time);
}
