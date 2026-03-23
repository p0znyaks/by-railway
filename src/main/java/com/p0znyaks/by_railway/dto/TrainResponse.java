package com.p0znyaks.by_railway.dto;

import com.p0znyaks.by_railway.entity.Train;
import com.p0znyaks.by_railway.enums.TrainType;

public record TrainResponse(Long id, String number, TrainType type) {
    public static TrainResponse from(Train train) {
        return new TrainResponse(train.getId(), train.getNumber(), train.getType());
    }
}
