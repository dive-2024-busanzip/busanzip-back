package com.example.busanzipback.domain.map.exception;

import java.io.Serial;

import com.example.busanzipback.common.exception.BusinessException;

public class AttractionNotFoundException extends BusinessException {

	@Serial
	private static final long serialVersionUID = -1299442836326965441L;

	public AttractionNotFoundException() {
		super(MapErrorCode.NOT_FOUND_ATTRACTION);
	}
}
