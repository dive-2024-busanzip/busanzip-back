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
public class SecurityFacility extends BaseEntity{

	@Id
	private Integer id;
	private String address;

	@Builder
	public SecurityFacility(Integer id, String address) {
		this.id = id;
		this.address = address;
	}
}
