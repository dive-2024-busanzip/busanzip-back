package com.example.busanzipback.domain.residency.dto.response;

import lombok.Builder;

@Builder
public record NearestItem(String item,
						  Double dist,
						  Integer distGroup,
						  Integer id,
						  String name,
						  Double latitude,
						  Double longitude) {
}
