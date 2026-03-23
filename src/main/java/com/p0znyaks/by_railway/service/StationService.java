package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.dto.StationRequest;
import com.p0znyaks.by_railway.dto.StationResponse;
import com.p0znyaks.by_railway.entity.Station;
import com.p0znyaks.by_railway.exception.StationNotFoundException;
import com.p0znyaks.by_railway.repository.StationRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StationService {
    private final StationRepository stationRepository;

    @Transactional(readOnly = true)
    public List<StationResponse> findAll() {
        return stationRepository.findAll().stream().map(StationResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public StationResponse findById(Long id) {
        return stationRepository
                .findById(id)
                .map(StationResponse::from)
                .orElseThrow(() -> new StationNotFoundException(id));
    }

    // TODO: Перебор ли здесь использовать Builder Pattern???
    @Transactional
    public StationResponse save(StationRequest request) {
        Station station = new Station(request.name(), request.city());
        return StationResponse.from(stationRepository.save(station));
    }

    @Transactional
    public void delete(Long id) {
        stationRepository.delete(
                stationRepository.findById(id).orElseThrow(() -> new StationNotFoundException(id)));
    }
}
