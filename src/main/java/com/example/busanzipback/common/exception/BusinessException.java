package com.example.busanzipback.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = 1472719331650424691L;
	private final ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode){
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public BusinessException(ErrorCode errorCode, Throwable throwable) {
		super(errorCode.getMessage(), throwable);
		this.errorCode = errorCode;
	}

	public BusinessException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
}
