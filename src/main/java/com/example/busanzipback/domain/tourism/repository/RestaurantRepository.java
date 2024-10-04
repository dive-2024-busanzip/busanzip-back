package com.example.busanzipback.domain.tourism.repository;

import com.example.busanzipback.domain.tourism.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
