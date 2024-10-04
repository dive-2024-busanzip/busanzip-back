package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Beach;
import com.example.busanzipback.domain.residency.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {
	Optional<Food> findById(Integer id);
}
