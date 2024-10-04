package com.example.busanzipback.domain.residency.dto.response;

import lombok.Builder;

@Builder
public record Job(String address,
				  String company,
				  String companyUrl,
				  Double distance,
				  String educationLevel,
				  String experience_level,
				  Integer id,
				  String industry,
				  String jobType,
				  String location,
				  Double latitude,
				  Double longitude,
				  String pageUrl,
				  String salary,
				  String title) {
}
