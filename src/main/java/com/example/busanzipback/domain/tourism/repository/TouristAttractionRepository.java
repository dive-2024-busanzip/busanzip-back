package com.example.busanzipback.domain.tourism.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.busanzipback.domain.tourism.entity.TouristAttraction;

public interface TouristAttractionRepository extends JpaRepository<TouristAttraction, Long> {

	@Query(value = "SELECT *, "
		+ "ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) as distance "
		+ "FROM tourist_attraction "
		+ "WHERE ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) <= 1000 "
		+ "ORDER BY distance",
		nativeQuery = true)
	List<TouristAttraction> findNearbyLocations(@Param("longitude") Double longitude, @Param("latitude") double latitude);

	Optional<TouristAttraction> findById(Long id);
}

