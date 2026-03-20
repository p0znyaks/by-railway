package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.entity.Station;
import com.p0znyaks.by_railway.exception.StationNotFoundException;
import com.p0znyaks.by_railway.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class StationService {
    private final StationRepository stationRepository;

    @Transactional(readOnly = true)
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Station findById(Long id) {
        return stationRepository.findById(id).orElseThrow(()-> new StationNotFoundException(id));
    }

    @Transactional
    public Station save(Station station) {
        return stationRepository.save(station);
    }

    @Transactional
    public void delete(Long id) {
        Station station = stationRepository.findById(id).orElseThrow(() -> new StationNotFoundException(id));
        stationRepository.delete(station);
    }
}