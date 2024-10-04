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
public class ParkingLot extends BaseEntity{

	@Id
	private Integer id;
	private String districtOffice;
	private String address;
	private String type;
	private Integer spaceCount;
	private Integer baseFee;
	private Integer dayFee;
	private Integer monthFee;
	private Integer baseTime;
	private Integer addTime;
	private Integer addFee;

	@Builder
	public ParkingLot(Integer id, String districtOffice, String address, String type, Integer spaceCount,
		Integer baseFee,
		Integer dayFee, Integer monthFee, Integer baseTime, Integer addTime, Integer addFee) {
		this.id = id;
		this.districtOffice = districtOffice;
		this.address = address;
		this.type = type;
		this.spaceCount = spaceCount;
		this.baseFee = baseFee;
		this.dayFee = dayFee;
		this.monthFee = monthFee;
		this.baseTime = baseTime;
		this.addTime = addTime;
		this.addFee = addFee;
	}
}
