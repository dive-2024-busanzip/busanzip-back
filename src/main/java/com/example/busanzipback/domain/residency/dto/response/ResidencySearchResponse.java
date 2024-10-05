package com.example.busanzipback.domain.residency.dto.response;

import java.util.List;

import com.example.busanzipback.domain.residency.dto.request.ResidencySearchRequest;
import com.example.busanzipback.domain.residency.entity.Distance;

import lombok.Builder;

@Builder
public record ResidencySearchResponse(Integer id,
									  String district,
									  String address,
									  Integer household,
									  String type,
									  String price,
									  String imgUrl,
									  Double latitude,
									  Double longitude,
									  List<NearestItem> nearestItemList,
									  List<Job> jobList
									  ) {

}
