package com.example.busanzipback.domain.residency.entity;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Distance {
	NEAR, MID, FAR;

	@JsonCreator
	public static Distance from(String s){
		return Distance.valueOf(s.toUpperCase());
	}

	@JsonValue
	public String toLowerCase() {
		return name().toLowerCase();
	}
}
