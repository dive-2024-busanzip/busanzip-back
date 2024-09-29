package com.example.busanzipback.domain.map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.busanzipback.domain.map.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@Query(value = "SELECT *, "
		+ "ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) as distance "
		+ "FROM restaurant "
		+ "WHERE ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) <= 1000 "
		+ "ORDER BY distance",
		nativeQuery = true)
	List<Restaurant> findNearbyLocations(@Param("longitude") Double longitude, @Param("latitude") double latitude);

}
