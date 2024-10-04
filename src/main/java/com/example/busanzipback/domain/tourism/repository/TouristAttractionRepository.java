package com.example.busanzipback.domain.tourism.repository;

import com.example.busanzipback.domain.tourism.entity.TouristAttraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristAttractionRepository extends JpaRepository<TouristAttraction, Long> {
}

