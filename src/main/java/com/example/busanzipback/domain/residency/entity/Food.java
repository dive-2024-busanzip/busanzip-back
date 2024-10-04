package com.example.busanzipback.domain.residency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food extends BaseEntity{

	@Id
	private Integer id;
	private String address;
	private String type;
	@Lob
	private String description;

	@Builder
	public Food(Integer id, String address, String type, String description) {
		this.id = id;
		this.address = address;
		this.type = type;
		this.description = description;
	}
}
