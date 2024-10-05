package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.tourism.entity.Shopping;

import lombok.Builder;

@Builder
public record GetShoppingDetailResponse(Long shoppingId,
										String name,
										Double latitude,
										Double longitude,
										String address,
										String phone,
										String homePageUrl,
										String usageDay,
										String holidayInfo,
										String usageTime,
										String usagePrice,
										String amenities,
										String imageUrl,
										String thumbnailUrl,
										String details) {


	public static GetShoppingDetailResponse from(Shopping shopping){
		return GetShoppingDetailResponse.builder()
			.shoppingId(shopping.getId())
			.name(shopping.getName())
			.latitude(shopping.getLatitude())
			.longitude(shopping.getLongitude())
			.address(shopping.getAddress())
			.phone(shopping.getPhone())
			.homePageUrl(shopping.getHomePageUrl())
			.usageDay(shopping.getUsageDay())
			.holidayInfo(shopping.getHolidayInfo())
			.usageTime(shopping.getUsageTime())
			.usagePrice(shopping.getUsagePrice())
			.amenities(shopping.getAmenities())
			.imageUrl(shopping.getImageUrl())
			.thumbnailUrl(shopping.getThumbnailUrl())
			.details(shopping.getDetails())
			.build();
	}
}
