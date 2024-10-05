package com.example.busanzipback.domain.map.exception;

import com.example.busanzipback.common.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MapErrorCode implements ErrorCode {
	OUT_OF_LONGITUDE_RANGE(400, "M001", "경도 값이 -180~180 범위를 벗어났습니다."),
	OUT_OF_LATITUDE_RANGE(400, "M002", "위도 값이 -90~90 범위를 벗아났습니다."),
	NOT_FOUND_RESTAURANT(404, "M003", "해당 식당을 찾을 수 없습니다."),
	NOT_FOUND_FESTIVITY(404, "M004", "해당 축제를 찾을 수 없습니다."),
	NOT_FOUND_ATTRACTION(404,"M005", "해당 명소를 찾을 수 없습니다."),
	NOT_FOUND_SHOPPING(404,"M006", "해당 쇼핑 장소를 찾을 수 없습니다.");

	private final int status;
	private final String code;
	private final String message;

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
