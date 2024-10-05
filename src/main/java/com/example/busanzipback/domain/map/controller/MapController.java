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
import com.example.busanzipback.domain.map.dto.response.GetAttractionDetailResponse;
import com.example.busanzipback.domain.map.dto.response.GetAttractionResponse;
import com.example.busanzipback.domain.map.dto.response.GetFestivityDetailResponse;
import com.example.busanzipback.domain.map.dto.response.GetFestivityResponse;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantDetailResponse;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantResponse;
import com.example.busanzipback.domain.map.dto.response.GetShoppingDetailResponse;
import com.example.busanzipback.domain.map.dto.response.GetShoppingResponse;
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
		@PathVariable Integer restaurantId
	){
		return SuccessResponse.of(mapService.getRestaurant(restaurantId)).asHttp(HttpStatus.OK);
	}

	@GetMapping("/festivity/nearby")
	public ResponseEntity<SuccessResponse<List<GetFestivityResponse>>> getFestivitiesNearby(
		@RequestParam(value = "latitude") Double latitude,
		@RequestParam(value = "longitude") Double longitude
	){
		return SuccessResponse.of(mapService.getFestivityList(latitude, longitude)).asHttp(HttpStatus.OK);
	}

	@GetMapping("/festivity/{festivityId}")
	public ResponseEntity<SuccessResponse<GetFestivityDetailResponse>> getFestivityDetail(
		@PathVariable Integer festivityId
	){
		return SuccessResponse.of(mapService.getFestivity(festivityId)).asHttp(HttpStatus.OK);
	}

	@GetMapping("/attraction/nearby")
	public ResponseEntity<SuccessResponse<List<GetAttractionResponse>>> getAttractionsNearby(
		@RequestParam(value = "latitude") Double latitude,
		@RequestParam(value = "longitude") Double longitude
	){
		return SuccessResponse.of(mapService.getAttractionList(latitude, longitude)).asHttp(HttpStatus.OK);
	}

	@GetMapping("/attraction/{attractionId}")
	public ResponseEntity<SuccessResponse<GetAttractionDetailResponse>> getAttractionDetail(
		@PathVariable Long attractionId
	){
		return SuccessResponse.of(mapService.getAttraction(attractionId)).asHttp(HttpStatus.OK);
	}

	@GetMapping("/shopping/nearby")
	public ResponseEntity<SuccessResponse<List<GetShoppingResponse>>> getShoppingNearby(
		@RequestParam(value = "latitude") Double latitude,
		@RequestParam(value = "longitude") Double longitude
	){
		return SuccessResponse.of(mapService.getShoppingList(latitude, longitude)).asHttp(HttpStatus.OK);
	}

	@GetMapping("/shopping/{shoppingId}")
	public ResponseEntity<SuccessResponse<GetShoppingDetailResponse>> getShoppingDetail(
		@PathVariable Long shoppingId
	){
		return SuccessResponse.of(mapService.getShopping(shoppingId)).asHttp(HttpStatus.OK);
	}
}
