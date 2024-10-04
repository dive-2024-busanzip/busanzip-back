package com.example.busanzipback.domain.residency.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	private String name;
	@Column(columnDefinition = "decimal(10, 6)", nullable = false)
	private Double latitude;
	@Column(columnDefinition = "decimal(10, 6)", nullable = false)
	private Double longitude;

}
