package com.example.busanzipback.domain.map.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.busanzipback.common.exception.BusinessException;
import com.example.busanzipback.domain.map.dto.response.GetRestaurantResponse;
import com.example.busanzipback.domain.map.exception.MapErrorCode;
import com.example.busanzipback.domain.map.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapService {

	private final RestaurantRepository restaurantRepository;

	public List<GetRestaurantResponse> getRestaurantList(Double latitude, Double longitude) {
		if(latitude > 90 || latitude < -90) throw new BusinessException(MapErrorCode.OUT_OF_LATITUDE_RANGE);
		if(longitude > 180 || longitude < -180) throw new BusinessException(MapErrorCode.OUT_OF_LONGITUDE_RANGE);
		return restaurantRepository.findNearbyLocations(longitude, latitude).stream().map(GetRestaurantResponse::from).toList();
	}

}
