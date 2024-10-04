package com.example.busanzipback.domain.tourism.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class CandidateResponse {
    private List<List<Long>> tours;
    private List<String> types;
}
