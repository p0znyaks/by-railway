package com.p0znyaks.by_railway.controller;

import com.p0znyaks.by_railway.dto.RouteRequest;
import com.p0znyaks.by_railway.dto.RouteResponse;
import com.p0znyaks.by_railway.service.RouteService;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
@AllArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @GetMapping
    public ResponseEntity<List<RouteResponse>> findAll() {
        return ResponseEntity.ok(routeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(routeService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<RouteResponse>> search(
            @RequestParam Long from,
            @RequestParam Long to,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime time) {
        return ResponseEntity.ok(routeService.findAvailableRoutes(from, to, time));
    }

    @PostMapping
    public ResponseEntity<RouteResponse> save(@Valid @RequestBody RouteRequest request) {
        RouteResponse response = routeService.save(request);
        return ResponseEntity.created(URI.create("/api/routes/" + response.id())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        routeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
