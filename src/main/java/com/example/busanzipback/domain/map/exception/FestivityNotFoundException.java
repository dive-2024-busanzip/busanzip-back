package com.example.busanzipback.domain.map.exception;

import java.io.Serial;

import com.example.busanzipback.common.exception.BusinessException;

public class FestivityNotFoundException extends BusinessException {

	@Serial
	private static final long serialVersionUID = 6528739311082141004L;

	public FestivityNotFoundException() {
		super(MapErrorCode.NOT_FOUND_FESTIVITY);
	}
}
