package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StationService {
    private final StationRepository stationRepository;
}