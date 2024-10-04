package com.example.busanzipback.domain.residency.entity;

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
public class Academy extends BaseEntity{

	@Id
	private Integer id;
	private String subject;
	private String address;

	@Builder
	public Academy(Integer id, String subject, String address) {
		this.id = id;
		this.subject = subject;
		this.address = address;
	}
}
