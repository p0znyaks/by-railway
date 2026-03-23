package com.p0znyaks.by_railway.controller;

import com.p0znyaks.by_railway.dto.StationRequest;
import com.p0znyaks.by_railway.dto.StationResponse;
import com.p0znyaks.by_railway.service.StationService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stations")
@AllArgsConstructor
public class StationController {
    private final StationService stationService;

    @GetMapping
    public ResponseEntity<List<StationResponse>> findAll() {
        return ResponseEntity.ok(stationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StationResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(stationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StationResponse> save(@Valid @RequestBody StationRequest request) {
        StationResponse response = stationService.save(request);
        return ResponseEntity.created(URI.create("/api/stations/" + response.id())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
