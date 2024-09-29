package com.example.busanzipback.common.dto;

import java.util.List;

import org.springframework.validation.FieldError;

import com.example.busanzipback.common.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

	private final boolean success = false;
	private final ErrorInfo data;

	public static ErrorResponse of(ErrorCode errorCode) {
		return new ErrorResponse(new ErrorInfo(errorCode.getCode(), errorCode.getMessage(), null));
	}

	public static ErrorResponse of(ErrorCode errorCode, List<ValidationError> validationErrorList) {
		return new ErrorResponse(new ErrorInfo(errorCode.getCode(), errorCode.getMessage(), validationErrorList));
	}

	public static ErrorResponse of(ErrorCode errorCode, String additionalMessage) {
		return new ErrorResponse(new ErrorInfo(errorCode.getCode(),
			errorCode.getMessage() + " : " + additionalMessage, null));
	}

	public record ValidationError(String field, String message) {

		public static ValidationError of(final FieldError fieldError) {
			return new ValidationError(fieldError.getField(), fieldError.getDefaultMessage());
		}
	}

	private record ErrorInfo(String code,
							 String message,
							 @JsonInclude(JsonInclude.Include.NON_EMPTY)
							 List<ValidationError> errors) {
	}
}
