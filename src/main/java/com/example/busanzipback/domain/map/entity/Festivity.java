package com.example.busanzipback.domain.map.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Festivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "festivity_id")
	private Integer id;
	@Column(nullable = false)
	private Integer contentId;
	@Column(nullable = false)
	private String contentName;
	@Column(nullable = false)
	private String district;
	@Column(columnDefinition = "decimal(10, 6)", nullable = false)
	private Double latitude;
	@Column(columnDefinition = "decimal(10, 6)", nullable = false)
	private Double longitude;
	private String place;
	private String title;
	private String subtitle;
	private String mainPlace;
	private String address;
	private String additionalAddress;
	private String contact;
	private String website;
	private String transportInfo;
	private String operationPeriod;
	private String operatingDaysHours;
	private String usageFee;
	private String imageUrl;
	private String thumbnailUrl;
	@Lob
	private String details;
	private String facilities;

	@Builder
	public Festivity(Integer contentId, String contentName, String district, Double latitude, Double longitude, String place, String title,
		String subtitle, String mainPlace, String address, String additionalAddress, String contact, String website,
		String transportInfo, String operationPeriod, String operatingDaysHours, String usageFee, String imageUrl,
		String thumbnailUrl, String details, String facilities) {
		this.contentId = contentId;
		this.contentName = contentName;
		this.district = district;
		this.latitude = latitude;
		this.longitude = longitude;
		this.place = place;
		this.title = title;
		this.subtitle = subtitle;
		this.mainPlace = mainPlace;
		this.address = address;
		this.additionalAddress = additionalAddress;
		this.contact = contact;
		this.website = website;
		this.transportInfo = transportInfo;
		this.operationPeriod = operationPeriod;
		this.operatingDaysHours = operatingDaysHours;
		this.usageFee = usageFee;
		this.imageUrl = imageUrl;
		this.thumbnailUrl = thumbnailUrl;
		this.details = details;
		this.facilities = facilities;
	}
}
