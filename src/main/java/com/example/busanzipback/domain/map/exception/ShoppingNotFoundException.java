package com.example.busanzipback.domain.map.exception;

import java.io.Serial;

import com.example.busanzipback.common.exception.BusinessException;

public class ShoppingNotFoundException extends BusinessException {

	@Serial
	private static final long serialVersionUID = 8490580722438321628L;

	public ShoppingNotFoundException() {
		super(MapErrorCode.NOT_FOUND_SHOPPING);
	}
}
