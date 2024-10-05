package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.map.entity.Festivity;
import com.example.busanzipback.domain.tourism.entity.TouristAttraction;

import lombok.Builder;

@Builder
public record GetAttractionResponse(Long attractionId,
									String name,
									Double latitude,
									Double longitude,
									String thumbnailImageUrl) {


	public static GetAttractionResponse from(TouristAttraction attraction){
		return GetAttractionResponse.builder()
			.attractionId(attraction.getId())
			.name(attraction.getName())
			.latitude(attraction.getLatitude())
			.longitude(attraction.getLongitude())
			.thumbnailImageUrl(attraction.getThumbnailUrl())
			.build();
	}
}
