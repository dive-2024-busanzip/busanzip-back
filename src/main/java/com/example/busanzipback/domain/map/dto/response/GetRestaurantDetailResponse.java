package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.map.entity.Restaurant;

import lombok.Builder;

@Builder
public record GetRestaurantDetailResponse(Integer restaurantId,
										  Integer contentId,
										  String restaurantName,
										  String district,
										  Double latitude,
										  Double longitude,
										  String address,
										  String contact,
										  String homepage,
										  String operatingHours,
										  String mainMenu,
										  String imageUrl,
										  String thumbnailImageUrl,
										  String details) {


	public static GetRestaurantDetailResponse from(Restaurant restaurant){
		return GetRestaurantDetailResponse.builder()
			.restaurantId(restaurant.getId())
			.contentId(restaurant.getContentId())
			.restaurantName(restaurant.getRestaurantName())
			.district(restaurant.getDistrict())
			.latitude(restaurant.getLatitude())
			.longitude(restaurant.getLongitude())
			.address(restaurant.getAddress())
			.contact(restaurant.getContact())
			.homepage(restaurant.getHomepage())
			.operatingHours(restaurant.getOperatingHours())
			.mainMenu(restaurant.getMainMenu())
			.imageUrl(restaurant.getImageUrl())
			.thumbnailImageUrl(restaurant.getThumbnailImageUrl())
			.details(restaurant.getDetails())
			.build();
	}
}
