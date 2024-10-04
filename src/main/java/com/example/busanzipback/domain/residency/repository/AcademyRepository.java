package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Academy;

public interface AcademyRepository extends JpaRepository<Academy, Integer> {
	Optional<Academy> findById(Integer id);
}
