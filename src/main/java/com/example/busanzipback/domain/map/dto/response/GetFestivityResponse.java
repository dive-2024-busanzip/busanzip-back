package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.map.entity.Festivity;

import lombok.Builder;

@Builder
public record GetFestivityResponse(Integer festivityId,
								   Integer contentId,
								   String contentName,
								   Double latitude,
								   Double longitude,
								   String thumbnailImageUrl,
								   String operatingDaysHours) {


	public static GetFestivityResponse from(Festivity festivity){
		return GetFestivityResponse.builder()
			.festivityId(festivity.getId())
			.contentId(festivity.getContentId())
			.contentName(festivity.getContentName())
			.latitude(festivity.getLatitude())
			.longitude(festivity.getLongitude())
			.thumbnailImageUrl(festivity.getThumbnailUrl())
			.operatingDaysHours(festivity.getOperatingDaysHours())
			.build();
	}
}
