package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.ParkingLot;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
	Optional<ParkingLot> findById(Integer id);
}
