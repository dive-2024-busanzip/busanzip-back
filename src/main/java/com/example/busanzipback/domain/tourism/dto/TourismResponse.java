package com.example.busanzipback.domain.tourism.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class TourismResponse {
    private List<Place> course;

    public static TourismResponse of(List<Place> course) {
        return new TourismResponse(course);
    }
}
