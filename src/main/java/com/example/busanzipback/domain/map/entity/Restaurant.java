package com.example.busanzipback.domain.map.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Integer id;
	@Column(nullable = false)
	private Integer contentId;
	@Column(nullable = false)
	private String restaurantName;
	@Column(nullable = false)
	private String district;
	@Column(columnDefinition = "decimal(10, 6)", nullable = false)
	private Double latitude;
	@Column(columnDefinition = "decimal(10, 6)", nullable = false)
	private Double longitude;
	@Column(nullable = false)
	private String address;
	private String contact;
	private String homepage;
	private String operatingHours;
	private String mainMenu;
	private String imageUrl;
	private String thumbnailImageUrl;
	private String details;

	@Builder
	public Restaurant(Integer contentId, String restaurantName, String district, Double latitude, Double longitude,
		String address,
		String contact, String homepage, String operatingHours, String mainMenu, String imageUrl,
		String thumbnailImageUrl, String details) {
		this.contentId = contentId;
		this.restaurantName = restaurantName;
		this.district = district;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.contact = contact;
		this.homepage = homepage;
		this.operatingHours = operatingHours;
		this.mainMenu = mainMenu;
		this.imageUrl = imageUrl;
		this.thumbnailImageUrl = thumbnailImageUrl;
		this.details = details;
	}
}
