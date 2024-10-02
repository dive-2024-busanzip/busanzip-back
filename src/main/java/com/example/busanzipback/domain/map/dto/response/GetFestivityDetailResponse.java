package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.map.entity.Festivity;
import com.example.busanzipback.domain.map.entity.Restaurant;

import lombok.Builder;

@Builder
public record GetFestivityDetailResponse(Integer festivityId,
										 String contentName,
										 String district,
										 Double latitude,
										 Double longitude,
										 String place,
										 String title,
										 String subtitle,
										 String mainPlace,
										 String address,
										 String additionalAddress,
										 String contact,
										 String website,
										 String transportInfo,
										 String operationPeriod,
										 String operatingDaysHours,
										 String usageFee,
										 String imageUrl,
										 String thumbnailUrl,
										 String details,
										 String facilities) {


	public static GetFestivityDetailResponse from(Festivity festivity){
		return GetFestivityDetailResponse.builder()
			.festivityId(festivity.getId())
			.contentName(festivity.getContentName())
			.district(festivity.getDistrict())
			.latitude(festivity.getLatitude())
			.longitude(festivity.getLongitude())
			.place(festivity.getPlace())
			.title(festivity.getTitle())
			.subtitle(festivity.getSubtitle())
			.mainPlace(festivity.getMainPlace())
			.address(festivity.getAddress())
			.additionalAddress(festivity.getAdditionalAddress())
			.contact(festivity.getContact())
			.website(festivity.getWebsite())
			.transportInfo(festivity.getTransportInfo())
			.operationPeriod(festivity.getOperationPeriod())
			.operatingDaysHours(festivity.getOperatingDaysHours())
			.usageFee(festivity.getUsageFee())
			.imageUrl(festivity.getImageUrl())
			.thumbnailUrl(festivity.getThumbnailUrl())
			.details(festivity.getDetails())
			.facilities(festivity.getFacilities())
			.build();
	}
}
