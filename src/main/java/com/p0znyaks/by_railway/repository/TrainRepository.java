package com.p0znyaks.by_railway.repository;

import com.p0znyaks.by_railway.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
}
