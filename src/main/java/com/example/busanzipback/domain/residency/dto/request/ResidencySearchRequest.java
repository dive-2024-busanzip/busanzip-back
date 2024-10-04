package com.example.busanzipback.domain.residency.dto.request;

import com.example.busanzipback.domain.residency.entity.Distance;
import com.example.busanzipback.domain.residency.util.DistanceValidation;

import jakarta.validation.constraints.NotNull;

public record ResidencySearchRequest(@DistanceValidation.ValidDistance Distance subwayStation,
									 @DistanceValidation.ValidDistance Distance publicParking,
									 @DistanceValidation.ValidDistance Distance traditionalMarket,
									 @NotNull Boolean slicedRawFish,
									 @NotNull Boolean koreanFood,
									 @NotNull Boolean japaneseFood,
									 @NotNull Boolean chineseFood,
									 @NotNull Boolean coffeeShop,
									 @NotNull Boolean convenienceStore,
									 @DistanceValidation.ValidDistance Distance policeStation,
									 @NotNull Boolean crimePreventionFacility,
									 @DistanceValidation.ValidDistance Distance kindergarten,
									 @DistanceValidation.ValidDistance Distance elementarySchool,
									 @DistanceValidation.ValidDistance Distance middleSchool,
									 @DistanceValidation.ValidDistance Distance highSchool,
									 @NotNull Boolean tutorAcademy,
									 @NotNull Boolean artAcademy,
									 @NotNull Boolean foreignLanguageAcademy,
									 @NotNull Boolean musicAcademy,
									 @NotNull Boolean danceAcademy,
									 @NotNull Boolean studyRoom,
									 @DistanceValidation.ValidDistance Distance beach,
									 @DistanceValidation.ValidDistance Distance park,
									 Double customLatitude,
									 Double customLongitude) {
}
