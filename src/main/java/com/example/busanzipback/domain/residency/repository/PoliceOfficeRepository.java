package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Food;
import com.example.busanzipback.domain.residency.entity.PoliceOffice;

public interface PoliceOfficeRepository extends JpaRepository<PoliceOffice, Integer> {
	Optional<PoliceOffice> findById(Integer id);
}
