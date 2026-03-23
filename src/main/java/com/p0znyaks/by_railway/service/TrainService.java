package com.p0znyaks.by_railway.service;

import com.p0znyaks.by_railway.dto.TrainRequest;
import com.p0znyaks.by_railway.dto.TrainResponse;
import com.p0znyaks.by_railway.entity.Train;
import com.p0znyaks.by_railway.exception.TrainNotFoundException;
import com.p0znyaks.by_railway.repository.TrainRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;

    @Transactional(readOnly = true)
    public List<TrainResponse> findAll() {
        return trainRepository.findAll().stream().map(TrainResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public TrainResponse findById(Long id) {
        return trainRepository
                .findById(id)
                .map(TrainResponse::from)
                .orElseThrow(() -> new TrainNotFoundException(id));
    }

    @Transactional
    public TrainResponse save(TrainRequest request) {
        Train train = new Train(request.number(), request.type());
        return TrainResponse.from(trainRepository.save(train));
    }

    @Transactional
    public void delete(Long id) {
        trainRepository.delete(
                trainRepository.findById(id).orElseThrow(() -> new TrainNotFoundException(id)));
    }
}
