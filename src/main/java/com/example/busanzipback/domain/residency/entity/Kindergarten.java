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
public class Kindergarten extends BaseEntity{

	@Id
	private Integer id;
	private String type;
	private String organization;
	private String address;
	private String phoneNumber;
	private String postalCode;

	@Builder
	public Kindergarten(Integer id, String type, String organization, String address, String phoneNumber,
		String postalCode) {
		this.id = id;
		this.type = type;
		this.organization = organization;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
	}
}
