package com.example.busanzipback.domain.tourism.service;

import com.example.busanzipback.domain.tourism.dto.CarRouteResponse;
import com.example.busanzipback.domain.tourism.dto.Place;
import com.example.busanzipback.domain.tourism.dto.TourismRequest;
import com.example.busanzipback.domain.tourism.dto.TourismResponse;
import com.example.busanzipback.domain.tourism.dto.TransitRouteRequest;
import com.example.busanzipback.domain.tourism.dto.TransitRouteRequest.LatLng;
import com.example.busanzipback.domain.tourism.dto.TransitRouteRequest.Location;
import com.example.busanzipback.domain.tourism.dto.TransitRouteRequest.Point;
import com.example.busanzipback.domain.tourism.dto.TransitRouteResponse;
import com.example.busanzipback.domain.tourism.entity.Accommodation;
import com.example.busanzipback.domain.tourism.entity.Experience;
import com.example.busanzipback.domain.tourism.entity.Shopping;
import com.example.busanzipback.domain.tourism.entity.TourismRestaurant;
import com.example.busanzipback.domain.tourism.entity.TouristAttraction;
import com.example.busanzipback.domain.tourism.entity.TravelType;
import com.example.busanzipback.domain.tourism.repository.AccommodationRepository;
import com.example.busanzipback.domain.tourism.repository.ExperienceRepository;
import com.example.busanzipback.domain.tourism.repository.TourismRestaurantRepository;
import com.example.busanzipback.domain.tourism.repository.ShoppingRepository;
import com.example.busanzipback.domain.tourism.repository.TouristAttractionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class TourismService {

    private final RestTemplate restTemplate;
    private static final String CAR_ROUTE_API_URL = "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving";
    private static final String TRANSIT_ROUTE_API_URL = "https://routes.googleapis.com/directions/v2:computeRoutes";
    @Value("${api.route.car.key-id}")
    private String CAR_ROUTE_API_KEY_ID;
    @Value("${api.route.car.key}")
    private String CAR_ROUTE_API_KEY;
    @Value("${api.route.transit.key}")
    private String TRANSIT_API_KEY;


    private final TourismRestaurantRepository tourismRestaurantRepository;
    private final ShoppingRepository shoppingRepository;
    private final TouristAttractionRepository touristAttractionRepository;
    private final ExperienceRepository experienceRepository;
    private final AccommodationRepository accommodationRepository;

    public TourismResponse create(TourismRequest request) {
        List<Long> restaurantCandidateIds = null;
        List<Long> shoppingCandidateIds = null;
        List<Long> touristAttractionCandidateIds = null;
        List<Long> experienceCandidateIds = null;
        int restaurantIdx = 0;
        int shoppingIdx = 0;
        int touristAttractionIdx = 0;
        int experienceIdx = 0;

        if(request.getEatingCount() > 0) {
            restaurantCandidateIds = getCandidateIds(request.getEatingRequirements(), TravelType.RESTAURANT);
            System.out.println(restaurantCandidateIds.size());
        }
        if(request.getShoppingCount() > 0) {
            shoppingCandidateIds = getCandidateIds(request.getShoppingRequirements(), TravelType.SHOPPING);
            System.out.println(shoppingCandidateIds.size());
        }
        if(request.getTouristAttractionCount() > 0) {
            touristAttractionCandidateIds = getCandidateIds(request.getTouristAttractionRequirements(), TravelType.TOURIST_ATTRACTION);
            System.out.println(touristAttractionCandidateIds.size());
        }
        if(request.getExperienceCount() > 0) {
            experienceCandidateIds = getCandidateIds(request.getExperienceRequirements(), TravelType.EXPERIENCE);
            System.out.println(experienceCandidateIds.size());
        }

        String[] sequence = request.getSequence();
        List<Place> placeList = new ArrayList<>();
        Place lastPlace = null;
        int maxMoveMin = request.getMaxMoveMin();
        boolean isUsingCar = request.getIsUsingCar();

        for (String type : sequence) {
            switch (type) {
                case "RESTAURANT":
                    lastPlace = addPlacesToCourse(placeList, restaurantCandidateIds, lastPlace, TravelType.RESTAURANT, maxMoveMin, isUsingCar, restaurantIdx);
                    restaurantIdx++;
                    break;
                case "SHOPPING":
                    lastPlace = addPlacesToCourse(placeList, shoppingCandidateIds, lastPlace, TravelType.SHOPPING, maxMoveMin, isUsingCar, shoppingIdx);
                    shoppingIdx++;
                    break;
                case "TOURIST_ATTRACTION":
                    lastPlace = addPlacesToCourse(placeList, touristAttractionCandidateIds, lastPlace, TravelType.TOURIST_ATTRACTION, maxMoveMin, isUsingCar, touristAttractionIdx);
                    touristAttractionIdx++;
                    break;
                case "EXPERIENCE":
                    lastPlace = addPlacesToCourse(placeList, experienceCandidateIds, lastPlace, TravelType.EXPERIENCE, maxMoveMin, isUsingCar, experienceIdx);
                    experienceIdx++;
                    break;
                case "ACCOMMODATION":
                    lastPlace = addAccommodationToCourse(placeList, lastPlace, request);
                    break;
            }
        }
        return TourismResponse.of(placeList);
    }

    // TODO: 스코어 매기기
    private List<Long> getCandidateIds(String eatingRequirements, TravelType travelType) {
        if(travelType == TravelType.RESTAURANT) {
            return tourismRestaurantRepository.findAll().stream()
                    .map(TourismRestaurant::getId)
                    .toList();
        }
        if(travelType == TravelType.SHOPPING) {
            return shoppingRepository.findAll().stream()
                    .map(Shopping::getId)
                    .toList();
        }
        if(travelType == TravelType.TOURIST_ATTRACTION) {
            return touristAttractionRepository.findAll().stream()
                    .map(TouristAttraction::getId)
                    .toList();
        }
        if(travelType == TravelType.EXPERIENCE) {
            return experienceRepository.findAll().stream()
                    .map(Experience::getId)
                    .toList();
        }
        throw new IllegalArgumentException();
    }

    private Place addPlacesToCourse(List<Place> placeList, List<Long> candidateIds, Place lastPlace, TravelType travelType, int maxMoveMin, boolean isUsingCar, int idx) {
        for (int i= idx; i < candidateIds.size(); i++) {
            Place place = getPlaceById(candidateIds.get(i), travelType);

            // 첫 장소인 경우
            if (lastPlace == null) {
                placeList.add(place);
                System.out.println("장소: " + place.getName());
                return place;
            }
            else {
                double travelTime = getTravelTime(lastPlace.getLatitude(), lastPlace.getLongitude(), place.getLatitude(), place.getLongitude(), isUsingCar);
                if (travelTime < maxMoveMin) {
                    placeList.add(place);
                    System.out.println("다음 장소: " + place.getName());
                    return place;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private Place addAccommodationToCourse(List<Place> placeList, Place lastPlace, TourismRequest request) {
        String[] keywords = request.getAccommodationKeywords();
        Place place = null;
        double latitude;
        double longitude;
        // 첫 장소인 경우
        if(lastPlace == null) {
            place = getFirstAccommodation(keywords);
        }
        else {
            latitude = lastPlace.getLatitude();
            longitude = lastPlace.getLongitude();
            Accommodation accommodation = accommodationRepository.findNearestByKeyword(latitude, longitude, keywords[0]).orElseThrow();
            place = getPlaceById(accommodation.getId(), TravelType.ACCOMMODATION);
        }
        placeList.add(place);
        return place;
    }

    private Place getFirstAccommodation(String[] keywords) {
        List<Accommodation> accommodations = new ArrayList<>();

        if(keywords.length == 0) {
            List<Accommodation> all = accommodationRepository.findAll();
            accommodations.addAll(all);
        }
        else {
            for(String keyword : keywords) {
                List<Accommodation> allByKeyword = accommodationRepository.findByKeyword(keyword);
                accommodations.addAll(allByKeyword);
            }
        }
        Random random = new Random();
        int randomIdx = random.nextInt(accommodations.size());
        return Place.from(accommodations.get(randomIdx));
    }

    private Place getPlaceById(Long id, TravelType travelType) {
        if(travelType == TravelType.RESTAURANT) {
            return Place.from(tourismRestaurantRepository.findById(id).orElseThrow());
        }
        if(travelType == TravelType.SHOPPING) {
            return Place.from(shoppingRepository.findById(id).orElseThrow());
        }
        if(travelType == TravelType.TOURIST_ATTRACTION) {
            return Place.from(touristAttractionRepository.findById(id).orElseThrow());
        }
        if(travelType == TravelType.EXPERIENCE) {
            return Place.from(experienceRepository.findById(id).orElseThrow());
        }
        if(travelType == TravelType.ACCOMMODATION) {
            return Place.from(accommodationRepository.findById(id).orElseThrow());
        }
        throw new IllegalArgumentException();
    }

    private int getTravelTime(Double startLat, Double startLng, Double endLat, Double endLng, boolean isUsingCar) {
        String start = startLng + "," + startLat;
        String goal = endLng + "," + endLat;

        if(isUsingCar) {
            String url = UriComponentsBuilder.fromHttpUrl(CAR_ROUTE_API_URL)
                    .queryParam("start", start)
                    .queryParam("goal", goal)
                    .toUriString();

            System.out.println(start);
            System.out.println(goal);

            HttpHeaders headers = new HttpHeaders();
            headers.set("X-NCP-APIGW-API-KEY-ID", CAR_ROUTE_API_KEY_ID);
            headers.set("X-NCP-APIGW-API-KEY", CAR_ROUTE_API_KEY);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<CarRouteResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, CarRouteResponse.class);
            long durationMilSec = response.getBody()
                    .getRoute().getTraoptimal().get(0)
                    .getSummary().getDuration();
            return (int) (durationMilSec / 60000);
        }
        else {
            String fieldMask = "routes.legs.duration";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Goog-Api-Key", TRANSIT_API_KEY);
            headers.set("X-Goog-FieldMask", fieldMask);

            LatLng startLatLng = new LatLng(startLat, startLng);
            LatLng endLatLng = new LatLng(endLat, endLng);
            Location startLocation = new Location(startLatLng);
            Location endLocation = new Location(endLatLng);

            Point origin = new Point(startLocation);
            Point destination = new Point(endLocation);

            TransitRouteRequest requestBody = new TransitRouteRequest(origin, destination, "2024-10-06T10:00:00Z",
                    "TRANSIT", "en-US", "IMPERIAL");

            HttpEntity<TransitRouteRequest> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<TransitRouteResponse> response = restTemplate.exchange(TRANSIT_ROUTE_API_URL,
                    HttpMethod.POST, entity, TransitRouteResponse.class);

            String duration = response.getBody()
                    .getRoutes().get(0)
                    .getLegs().get(0)
                    .getDuration();

            int sec = Integer.parseInt(duration.replace("s", ""));
            return sec / 60;
        }
    }
}
