package com.example.busanzipback.domain.map.exception;

import java.io.Serial;

import com.example.busanzipback.common.exception.BusinessException;

public class RestaurantNotFoundException extends BusinessException {
	@Serial
	private static final long serialVersionUID = -6278853952665367397L;

	public RestaurantNotFoundException() {
		super(MapErrorCode.NOT_FOUND_RESTAURANT);
	}
}
