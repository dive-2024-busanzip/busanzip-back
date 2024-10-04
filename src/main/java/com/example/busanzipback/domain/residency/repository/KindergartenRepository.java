package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Food;
import com.example.busanzipback.domain.residency.entity.Kindergarten;

public interface KindergartenRepository extends JpaRepository<Kindergarten, Integer> {
	Optional<Kindergarten> findById(Integer id);
}
