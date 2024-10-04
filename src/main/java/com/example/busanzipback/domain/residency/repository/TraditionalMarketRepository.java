package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Food;
import com.example.busanzipback.domain.residency.entity.TraditionalMarket;

public interface TraditionalMarketRepository extends JpaRepository<TraditionalMarket, String> {
	Optional<TraditionalMarket> findById(String id);
}
