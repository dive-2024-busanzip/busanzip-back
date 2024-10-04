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
public class ElementarySchool extends BaseEntity{

	@Id
	private Integer id;
	private String phoneNumber;
	private String postalCode;
	private String address;
	private String type;

	@Builder
	public ElementarySchool(Integer id, String phoneNumber, String postalCode, String address, String type) {
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
		this.address = address;
		this.type = type;
	}
}
