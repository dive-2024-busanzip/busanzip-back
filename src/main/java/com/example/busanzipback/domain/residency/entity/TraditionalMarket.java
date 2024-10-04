package com.example.busanzipback.domain.residency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TraditionalMarket extends BaseEntity{

	@Id
	private String id;
	private String address;
	private Boolean hasArcade;
	private Boolean hasElevatorEscalator;
	private Boolean hasCustomerSupportCenter;
	private Boolean hasSpringCooler;
	private Boolean hasFireDetector;
	private Boolean hasPlayroom;
	private Boolean hasCallCenter;
	private Boolean hasCustomerRestroom;
	private Boolean hasNursingRoom;
	private Boolean hasLocker;
	private Boolean hasBicycleParking;
	private Boolean hasSportsFacility;
	private Boolean hasMiniLibrary;
	private Boolean hasShoppingCart;
	private Boolean hasForeignCenter;
	private Boolean hasCustomerPath;
	private Boolean hasBroadcastCenter;
	private Boolean hasCulturalClass;
	private Boolean hasPublicWarehouse;
	private Boolean hasParkingLot;
	private Boolean hasTrainingRoom;
	private Boolean hasConferenceRoom;
	private Boolean hasAed;

	@Builder
	public TraditionalMarket(String id, String address, Boolean hasArcade, Boolean hasElevatorEscalator,
		Boolean hasCustomerSupportCenter, Boolean hasSpringCooler, Boolean hasFireDetector, Boolean hasPlayroom,
		Boolean hasCallCenter, Boolean hasCustomerRestroom, Boolean hasNursingRoom, Boolean hasLocker,
		Boolean hasBicycleParking, Boolean hasSportsFacility, Boolean hasMiniLibrary, Boolean hasShoppingCart,
		Boolean hasForeignCenter, Boolean hasCustomerPath, Boolean hasBroadcastCenter, Boolean hasCulturalClass,
		Boolean hasPublicWarehouse, Boolean hasParkingLot, Boolean hasTrainingRoom, Boolean hasConferenceRoom,
		Boolean hasAed) {
		this.id = id;
		this.address = address;
		this.hasArcade = hasArcade;
		this.hasElevatorEscalator = hasElevatorEscalator;
		this.hasCustomerSupportCenter = hasCustomerSupportCenter;
		this.hasSpringCooler = hasSpringCooler;
		this.hasFireDetector = hasFireDetector;
		this.hasPlayroom = hasPlayroom;
		this.hasCallCenter = hasCallCenter;
		this.hasCustomerRestroom = hasCustomerRestroom;
		this.hasNursingRoom = hasNursingRoom;
		this.hasLocker = hasLocker;
		this.hasBicycleParking = hasBicycleParking;
		this.hasSportsFacility = hasSportsFacility;
		this.hasMiniLibrary = hasMiniLibrary;
		this.hasShoppingCart = hasShoppingCart;
		this.hasForeignCenter = hasForeignCenter;
		this.hasCustomerPath = hasCustomerPath;
		this.hasBroadcastCenter = hasBroadcastCenter;
		this.hasCulturalClass = hasCulturalClass;
		this.hasPublicWarehouse = hasPublicWarehouse;
		this.hasParkingLot = hasParkingLot;
		this.hasTrainingRoom = hasTrainingRoom;
		this.hasConferenceRoom = hasConferenceRoom;
		this.hasAed = hasAed;
	}
}
