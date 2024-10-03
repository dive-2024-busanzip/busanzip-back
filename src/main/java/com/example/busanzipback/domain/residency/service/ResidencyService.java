package com.example.busanzipback.domain.residency.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.busanzipback.domain.residency.dto.request.ResidencySearchRequest;
import com.example.busanzipback.domain.residency.dto.response.NearestItem;
import com.example.busanzipback.domain.residency.dto.response.ResidencySearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResidencyService {

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	public List<ResidencySearchResponse> searchResidency(ResidencySearchRequest residencySearchRequest) {
		String pythonApiUrl = "http://localhost:5000/recommend_houses";

		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		Map<String, Object> requestBody = objectMapper.convertValue(residencySearchRequest, Map.class);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
		ResponseEntity<Map> pythonResponse = restTemplate.exchange(
			pythonApiUrl,
			HttpMethod.POST,
			requestEntity,
			Map.class
		);

		Map<String, Object> responseBody = new HashMap<>(pythonResponse.getBody());
		System.out.println();

		List<Map<String, Object>> recommendedHouseList = (List<Map<String, Object>>) responseBody.get("recommended_houses");
		return recommendedHouseList.stream().map(house -> {
			return ResidencySearchResponse.builder()
				.id((Integer)house.get("id"))
				.district((String)house.get("district"))
				.address((String)house.get("address"))
				.household((Integer)house.get("household"))
				.latitude((Double)house.get("latitude"))
				.longitude((Double)house.get("longitude"))
				.nearestItemList(pasingNearestItemList(house))
				.type((String)house.get("type"))
				.build();
		}).collect(Collectors.toList());
	}

	private List<NearestItem> pasingNearestItemList(Map<String, Object> house) {
		return null;
	}

}
