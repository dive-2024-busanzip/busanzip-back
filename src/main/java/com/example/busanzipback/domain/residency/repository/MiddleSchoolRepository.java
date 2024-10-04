package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Food;
import com.example.busanzipback.domain.residency.entity.MiddleSchool;

public interface MiddleSchoolRepository extends JpaRepository<MiddleSchool, Integer> {
	Optional<MiddleSchool> findById(Integer id);
}
