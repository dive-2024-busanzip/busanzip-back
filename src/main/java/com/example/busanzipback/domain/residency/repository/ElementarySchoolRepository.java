package com.example.busanzipback.domain.residency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busanzipback.domain.residency.entity.Academy;
import com.example.busanzipback.domain.residency.entity.ElementarySchool;

public interface ElementarySchoolRepository extends JpaRepository<ElementarySchool, Integer> {
	Optional<ElementarySchool> findById(Integer id);
}
