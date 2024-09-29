package com.example.busanzipback.common.exception;

import java.io.Serializable;

public interface ErrorCode extends Serializable {
	int getStatus();
	String getCode();
	String getMessage();
}
