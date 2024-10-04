package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.SecurityFacility;

public interface SecurityFacilityRepository extends JpaRepository<SecurityFacility, Integer> {
	Optional<SecurityFacility> findById(Integer id);
}
