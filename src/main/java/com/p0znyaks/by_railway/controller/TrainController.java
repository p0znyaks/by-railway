package com.p0znyaks.by_railway.controller;

import com.p0znyaks.by_railway.dto.TrainRequest;
import com.p0znyaks.by_railway.dto.TrainResponse;
import com.p0znyaks.by_railway.service.TrainService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trains")
@AllArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @GetMapping
    public ResponseEntity<List<TrainResponse>> findAll() {
        return ResponseEntity.ok(trainService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(trainService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TrainResponse> save(@Valid @RequestBody TrainRequest request) {
        TrainResponse response = trainService.save(request);
        return ResponseEntity.created(URI.create("/api/trains/" + response.id())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
