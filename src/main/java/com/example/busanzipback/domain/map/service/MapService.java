package com.example.busanzipback.domain.map.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.busanzipback.common.exception.BusinessException;
import com.example.busanzipback.domain.map.dto.response.GetFestivityDetailResponse;
import com.example.busanzipback.domain.map.dto.response.GetFestivityResponse;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantDetailResponse;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantResponse;
import com.example.busanzipback.domain.map.entity.Festivity;
import com.example.busanzipback.domain.map.entity.Restaurant;
import com.example.busanzipback.domain.map.exception.FestivityNotFoundException;
import com.example.busanzipback.domain.map.exception.MapErrorCode;
import com.example.busanzipback.domain.map.exception.RestaurantNotFoundException;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantResponse;
import com.example.busanzipback.domain.map.exception.MapErrorCode;
import com.example.busanzipback.domain.map.repository.FestivityRepository;
import com.example.busanzipback.domain.map.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapService {

	private final RestaurantRepository restaurantRepository;
	private final FestivityRepository festivityRepository;

	public List<GetRestaurantResponse> getRestaurantList(Double latitude, Double longitude) {
		checkPositionValue(latitude, longitude);
		return restaurantRepository.findNearbyLocations(longitude, latitude).stream().map(GetRestaurantResponse::from).toList();
	}

	public GetRestaurantDetailResponse getRestaurant(Integer restaurantId) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(RestaurantNotFoundException::new);
		return GetRestaurantDetailResponse.from(restaurant);
	}

	public List<GetFestivityResponse> getFestivityList(Double latitude, Double longitude) {
		checkPositionValue(latitude, longitude);
		return festivityRepository.findNearbyLocations(longitude, latitude).stream().map(GetFestivityResponse::from).toList();
	}

	public GetFestivityDetailResponse getFestivity(Integer festivityId) {
		Festivity festivity = festivityRepository.findById(festivityId).orElseThrow(FestivityNotFoundException::new);
		return GetFestivityDetailResponse.from(festivity);
	}


	private void checkPositionValue(Double latitude, Double longitude){
		if(latitude > 90 || latitude < -90) throw new BusinessException(MapErrorCode.OUT_OF_LATITUDE_RANGE);
		if(longitude > 180 || longitude < -180) throw new BusinessException(MapErrorCode.OUT_OF_LONGITUDE_RANGE);
	}
}
