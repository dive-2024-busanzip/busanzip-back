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
public class PoliceOffice extends BaseEntity{

	@Id
	private Integer id;
	private String station;
	private String type;
	private String phoneNumber;
	private String address;

	@Builder
	public PoliceOffice(Integer id, String station, String type, String phoneNumber, String address) {
		this.id = id;
		this.station = station;
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
}
