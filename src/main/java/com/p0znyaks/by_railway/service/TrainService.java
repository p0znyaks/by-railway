package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.entity.Train;
import com.p0znyaks.by_railway.exception.TrainNotFoundException;
import com.p0znyaks.by_railway.repository.TrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;

    @Transactional(readOnly = true)
    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Train findById(Long id) {
        return trainRepository.findById(id).orElseThrow(()-> new TrainNotFoundException(id));
    }

    @Transactional
    public Train save(Train train) {
        return trainRepository.save(train);
    }

    @Transactional
    public void delete(Long id) {
        Train train = trainRepository.findById(id).orElseThrow(() -> new TrainNotFoundException(id));
        trainRepository.delete(train);
    }
}
