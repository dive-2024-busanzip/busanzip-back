package com.example.busanzipback.domain.residency.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.busanzipback.domain.residency.dto.request.ResidencySearchRequest;
import com.example.busanzipback.domain.residency.dto.response.Job;
import com.example.busanzipback.domain.residency.dto.response.NearestItem;
import com.example.busanzipback.domain.residency.dto.response.ResidencySearchResponse;
import com.example.busanzipback.domain.residency.util.RepositoryMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
@RequiredArgsConstructor
public class ResidencyService {

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	private final RepositoryMapper repositoryMapper;

	public List<ResidencySearchResponse> searchResidency(ResidencySearchRequest residencySearchRequest) {
		String pythonApiUrl = "http://172.31.0.121:5000/recommend_houses";

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
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
		Map<String, Object> responseBody = new HashMap<>(Objects.requireNonNull(pythonResponse.getBody()));
		System.out.println();

		List<Map<String, Object>> recommendedHouseList = (List<Map<String, Object>>) responseBody.get("recommended_houses");
		return recommendedHouseList.stream().map(house -> {
			return ResidencySearchResponse.builder()
				.id((Integer)house.get("id"))
				.district((String)house.get("district"))
				.address((String)house.get("address"))
				.household((Integer)house.get("household"))
				.type((String)house.get("type"))
				.latitude((Double)house.get("latitude"))
				.longitude((Double)house.get("longitude"))
				.jobList(passingJobList(house))
				.nearestItemList(passingNearestItemList(house))
				.build();
		}).collect(Collectors.toList());
	}

	private List<Job> passingJobList(Map<String, Object> house) {
		List<Map<String, Object>> jobList = (List<Map<String, Object>>) house.get("jobs");
		return jobList.stream().map(job -> {
			return Job.builder()
				.address((String)job.get("address"))
				.company((String)job.get("company"))
				.companyUrl((String)job.get("company_url"))
				.distance((Double)job.get("distance"))
				.educationLevel((String)job.get("education Level"))
				.experience_level((String)job.get("experience_lecel"))
				.id((Integer)job.get("id"))
				.industry((String)job.get("industry"))
				.jobType((String)job.get("job_type"))
				.location((String)job.get("location"))
				.latitude((Double)job.get("latitude"))
				.longitude((Double)job.get("longitude"))
				.pageUrl((String)job.get("page_url"))
				.salary((String)job.get("salary"))
				.title((String)job.get("title"))
				.build();
		}).collect(Collectors.toList());
	}

	private List<NearestItem> passingNearestItemList(Map<String, Object> house) {
		List<NearestItem> nearestItemList = new ArrayList<>();
		Map<String, Item> itemMap = new HashMap<>();
		for(String key : house.keySet()){
			if(!key.contains("nearest")) continue;
			String category = getCategory(key);
			Item item = itemMap.getOrDefault(category, new Item(category));
			if(key.contains("dist_group")) item.setDistGroup((Integer)house.get(key));
			else if(key.contains("dist")) item.setDist((Double)house.get(key));
			else if(key.contains("id")) item.setId(house.get(key));
			itemMap.put(category, item);
		}
		for(Item item : itemMap.values()){
			Object[] info = repositoryMapper.getDetailInfoById(item.getCategory(), item.getId());
			nearestItemList.add(NearestItem.builder()
					.item(item.getCategory())
					.dist(item.getDist())
					.distGroup(item.getDistGroup())
					.id(item.getId())
					.name((String)info[0])
					.latitude((Double)info[1])
					.longitude((Double)info[2])
					.build());
		}
		return nearestItemList;
	}

	private String getCategory(String key){
		String category = key.replace("nearest_", "");
		if(category.contains("dist_group")) category = category.replace("_dist_group", "");
		else if(category.contains("dist")) category = category.replace("_dist", "");
		else if(category.contains("id")) category = category.replace("_id", "");
		return category;
	}

	@Getter
	@Setter
	private static class Item{

		String category;
		Double dist;
		Integer distGroup;
		Object id;

		public Item(String category){
			this.category = category;
		}
	}
}
