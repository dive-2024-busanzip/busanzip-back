package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.map.entity.Restaurant;

import lombok.Builder;

@Builder
public record GetRestaurantResponse(Integer restaurantId,
									Integer contentId,
									String restaurantName,
									Double latitude,
									Double longitude,
									String thumbnailImageUrl) {


	public static GetRestaurantResponse from(Restaurant restaurant){
		return GetRestaurantResponse.builder()
			.restaurantId(restaurant.getId())
			.contentId(restaurant.getContentId())
			.restaurantName(restaurant.getRestaurantName())
			.latitude(restaurant.getLatitude())
			.longitude(restaurant.getLongitude())
			.thumbnailImageUrl(restaurant.getThumbnailImageUrl())
			.build();
	}
}
