package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Academy;
import com.example.busanzipback.domain.residency.entity.Beach;

public interface BeachRepository extends JpaRepository<Beach, Integer> {
	Optional<Beach> findById(Integer id);
}
