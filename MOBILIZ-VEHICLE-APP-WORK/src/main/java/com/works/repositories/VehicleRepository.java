package com.works.repositories;

import com.works.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    boolean existsByVidEqualsAndUidEquals(Long vid, Long uid);

}