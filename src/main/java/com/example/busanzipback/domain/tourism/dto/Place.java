package com.example.busanzipback.domain.tourism.dto;


import com.example.busanzipback.domain.tourism.entity.Accommodation;
import com.example.busanzipback.domain.tourism.entity.Experience;
import com.example.busanzipback.domain.tourism.entity.TourismRestaurant;
import com.example.busanzipback.domain.tourism.entity.Shopping;
import com.example.busanzipback.domain.tourism.entity.TouristAttraction;
import com.example.busanzipback.domain.tourism.entity.TravelType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class Place {

    private String type;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private String usageDay; // X(NULL): 맛집, 숙박
    private String holiday; // X(NULL): 맛집, 숙박
    private String usageTime; // X(NULL): 숙박
    private String imageURL; // X(NULL): 숙박
    private String usagePrice; // X(NULL): 맛집, 숙박
    private String contact;
    private String repMenu; // X(NULL): 쇼핑, 명소, 체험, 숙박

    public static Place from(TourismRestaurant tourismRestaurant) {
        return Place.builder()
                .type(TravelType.RESTAURANT.getTravelTypeStr())
                .name(tourismRestaurant.getName())
                .description(tourismRestaurant.getDetails())
                .latitude(tourismRestaurant.getLatitude())
                .longitude(tourismRestaurant.getLongitude())
                .usageTime(tourismRestaurant.getUsageTime())
                .imageURL(tourismRestaurant.getThumbnailUrl())
                .contact(tourismRestaurant.getPhone())
                .repMenu(tourismRestaurant.getRepresentativeMenu())
                .build();
    }

    public static Place from(Shopping shopping) {
        return Place.builder()
                .type(TravelType.SHOPPING.getTravelTypeStr())
                .name(shopping.getName())
                .description(shopping.getDetails())
                .latitude(shopping.getLatitude())
                .longitude(shopping.getLongitude())
                .usageDay(shopping.getUsageDay())
                .holiday(shopping.getHolidayInfo())
                .usageTime(shopping.getUsageTime())
                .imageURL(shopping.getThumbnailUrl())
                .usagePrice(shopping.getUsagePrice())
                .contact(shopping.getPhone())
                .build();
    }

    public static Place from(TouristAttraction touristAttraction) {
        return Place.builder()
                .type(TravelType.TOURIST_ATTRACTION.getTravelTypeStr())
                .name(touristAttraction.getName())
                .description(touristAttraction.getDetails())
                .latitude(touristAttraction.getLatitude())
                .longitude(touristAttraction.getLongitude())
                .usageDay(touristAttraction.getUsageDay())
                .holiday(touristAttraction.getHolidayInfo())
                .usageTime(touristAttraction.getUsageTime())
                .imageURL(touristAttraction.getThumbnailUrl())
                .usagePrice(touristAttraction.getUsagePrice())
                .contact(touristAttraction.getPhone())
                .build();
    }

    public static Place from(Experience experience) {
        return Place.builder()
                .type(TravelType.EXPERIENCE.getTravelTypeStr())
                .name(experience.getName())
                .description(experience.getDetails())
                .latitude(experience.getLatitude())
                .longitude(experience.getLongitude())
                .usageDay(experience.getUsageDay())
                .holiday(experience.getHolidayInfo())
                .usageTime(experience.getUsageTime())
                .imageURL(experience.getThumbnailUrl())
                .usagePrice(experience.getUsagePrice())
                .contact(experience.getPhone())
                .build();
    }

    public static Place from(Accommodation accommodation) {
        return Place.builder()
                .type(TravelType.ACCOMMODATION.getTravelTypeStr())
                .name(accommodation.getName())
                .latitude(accommodation.getLatitude())
                .longitude(accommodation.getLongitude())
                .contact(accommodation.getPhoneNumber())
                .build();
    }
}
