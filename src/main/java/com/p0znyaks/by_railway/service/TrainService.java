package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.repository.TrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;
}
