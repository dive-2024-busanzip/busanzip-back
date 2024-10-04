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
public class SubwayStation extends BaseEntity{

	@Id
	private Integer id;
	private String line;
	private String nameEn;
	private String address;
	private String phoneNumber;

	@Builder
	public SubwayStation(Integer id, String line, String nameEn, String address, String phoneNumber) {
		this.id = id;
		this.line = line;
		this.nameEn = nameEn;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
}
