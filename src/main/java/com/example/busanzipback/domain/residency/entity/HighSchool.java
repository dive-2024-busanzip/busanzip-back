package com.example.busanzipback.domain.residency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HighSchool extends BaseEntity{

	@Id
	private Integer id;
	private String address;
	private String type;

	@Builder
	public HighSchool(Integer id, String address, String type) {
		this.id = id;
		this.address = address;
		this.type = type;
	}
}
