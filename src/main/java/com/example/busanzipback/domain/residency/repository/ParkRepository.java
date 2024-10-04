package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Food;
import com.example.busanzipback.domain.residency.entity.Park;

public interface ParkRepository extends JpaRepository<Park, Integer> {
	Optional<Park> findById(Integer id);
}
