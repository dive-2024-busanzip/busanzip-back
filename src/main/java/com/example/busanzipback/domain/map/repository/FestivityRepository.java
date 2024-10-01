package com.example.busanzipback.domain.map.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.busanzipback.domain.map.entity.Festivity;
import com.example.busanzipback.domain.map.entity.Restaurant;

public interface FestivityRepository extends JpaRepository<Festivity, Long> {

	@Query(value = "SELECT *, "
		+ "ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) as distance "
		+ "FROM festivity "
		+ "WHERE ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) <= 1000 "
		+ "ORDER BY distance",
		nativeQuery = true)
	List<Festivity> findNearbyLocations(@Param("longitude") Double longitude, @Param("latitude") double latitude);

	Optional<Festivity> findById(Long festivityId);
}
