package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.SubwayStation;

public interface SubwayStationRepository extends JpaRepository<SubwayStation, Integer> {
	Optional<SubwayStation> findById(Integer id);
}
