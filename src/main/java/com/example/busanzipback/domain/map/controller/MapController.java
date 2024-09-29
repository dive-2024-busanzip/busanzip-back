package com.example.busanzipback.domain.map.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.busanzipback.common.dto.SuccessResponse;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantDetailResponse;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantResponse;
import com.example.busanzipback.domain.map.service.MapService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/map")
@RequiredArgsConstructor
public class MapController {

	private final MapService mapService;

	@GetMapping("/restaurants/nearby")
	public ResponseEntity<SuccessResponse<List<GetRestaurantResponse>>> getRestaurantsNearby(
		@RequestParam(value = "latitude") Double latitude,
		@RequestParam(value = "longitude") Double longitude
	){
		return SuccessResponse.of(mapService.getRestaurantList(latitude, longitude)).asHttp(HttpStatus.OK);
	}

	@GetMapping("/restaurants/{restaurantId}")
	public ResponseEntity<SuccessResponse<GetRestaurantDetailResponse>> getRestaurantDetail(
		@PathVariable Long restaurantId
	){
		return SuccessResponse.of(mapService.getRestaurant(restaurantId)).asHttp(HttpStatus.OK);
	}
}
