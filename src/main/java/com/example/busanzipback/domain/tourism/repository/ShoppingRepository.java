package com.example.busanzipback.domain.tourism.repository;

import java.util.List;
import java.util.Optional;

import com.example.busanzipback.domain.tourism.entity.Shopping;
import com.example.busanzipback.domain.tourism.entity.TouristAttraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShoppingRepository extends JpaRepository<Shopping, Long> {

	@Query(value = "SELECT *, "
		+ "ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) as distance "
		+ "FROM shopping "
		+ "WHERE ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) <= 1000 "
		+ "ORDER BY distance",
		nativeQuery = true)
	List<Shopping> findNearbyLocations(@Param("longitude") Double longitude, @Param("latitude") double latitude);

	Optional<Shopping> findById(Long id);
}
