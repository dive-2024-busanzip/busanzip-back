package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.map.entity.Festivity;
import com.example.busanzipback.domain.tourism.entity.TouristAttraction;
import com.example.busanzipback.domain.tourism.entity.TravelType;

import lombok.Builder;

@Builder
public record GetAttractionDetailResponse(Long attractionId,
										  TravelType travelType,
										  String name,
										  Double latitude,
										  Double longitude,
										  String title,
										  String subTitle,
										  String address,
										  String phone,
										  String imageUrl,
										  String thumbnailUrl,
										  String homePageUrl,
										  String usageTime,
										  String usageDay,
										  String holidayInfo,
										  String usagePrice,
										  String amenities,
										  String details
										  ) {


	public static GetAttractionDetailResponse from(TouristAttraction attraction){
		return GetAttractionDetailResponse.builder()
			.attractionId((attraction.getId()))
			.travelType(attraction.getTravelType())
			.name((attraction.getName()))
			.latitude(attraction.getLatitude())
			.longitude(attraction.getLongitude())
			.title(attraction.getTitle())
			.subTitle(attraction.getSubTitle())
			.address(attraction.getAddress())
			.phone(attraction.getPhone())
			.imageUrl(attraction.getImageUrl())
			.thumbnailUrl(attraction.getThumbnailUrl())
			.homePageUrl(attraction.getHomePageUrl())
			.usageTime(attraction.getUsageTime())
			.usageDay(attraction.getUsageDay())
			.holidayInfo(attraction.getHolidayInfo())
			.usagePrice(attraction.getUsagePrice())
			.amenities((attraction.getAmenities()))
			.details(attraction.getDetails())
			.build();
	}
}
