package com.example.busanzipback.domain.map.dto.response;

import com.example.busanzipback.domain.tourism.entity.Shopping;
import com.example.busanzipback.domain.tourism.entity.TouristAttraction;

import lombok.Builder;

@Builder
public record GetShoppingResponse(Long shoppingId,
								  String name,
								  Double latitude,
								  Double longitude,
								  String thumbnailImageUrl) {


	public static GetShoppingResponse from(Shopping shopping){
		return GetShoppingResponse.builder()
			.shoppingId(shopping.getId())
			.name(shopping.getName())
			.latitude(shopping.getLatitude())
			.longitude(shopping.getLongitude())
			.thumbnailImageUrl(shopping.getThumbnailUrl())
			.build();
	}
}
