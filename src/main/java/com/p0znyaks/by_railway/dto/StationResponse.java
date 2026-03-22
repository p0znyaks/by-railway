package com.p0znyaks.by_railway.dto;

import com.p0znyaks.by_railway.entity.Station;

// TODO: маппинг через статический метод сейчас. В будущем через MapStruct сделать во всех DTO
public record StationResponse(Long id, String name, String city) {
    public static StationResponse from(Station station) {
        return new StationResponse(
                station.getId(),
                station.getName(),
                station.getCity()
        );
    }
}
