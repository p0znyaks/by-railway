package com.p0znyaks.by_railway.repository;

import com.p0znyaks.by_railway.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}