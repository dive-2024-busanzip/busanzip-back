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
public class Park extends BaseEntity{

	@Id
	private Integer id;
	private String type;
	private String address;

	@Builder
	public Park(Integer id, String type, String address) {
		this.id = id;
		this.type = type;
		this.address = address;
	}
}
