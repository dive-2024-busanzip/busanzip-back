package com.example.busanzipback.domain.residency.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busanzipback.common.dto.SuccessResponse;
import com.example.busanzipback.domain.residency.dto.request.ResidencySearchRequest;
import com.example.busanzipback.domain.residency.dto.response.ResidencySearchResponse;
import com.example.busanzipback.domain.residency.service.ResidencyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/residency")
@RequiredArgsConstructor
public class ResidencyController {

	private final ResidencyService residencyService;

	@PostMapping("/search")
	public ResponseEntity<SuccessResponse<List<ResidencySearchResponse>>> searchResidencyApi(
		@Valid  @RequestBody ResidencySearchRequest residencySearchRequest){
		return SuccessResponse.of(residencyService.searchResidency(residencySearchRequest)).asHttp(HttpStatus.OK);
	}
}
