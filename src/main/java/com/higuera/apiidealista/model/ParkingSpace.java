package com.higuera.apiidealista.model;

public class ParkingSpace {

	private Boolean hasParkingSpace;
	private Boolean isParkingSpaceIncludedInPrice;  
	private Double parkingSpacePrice;
	
	public ParkingSpace() {
		
	}
	
	public ParkingSpace(Boolean hasParkingSpace, Boolean isParkingSpaceIncludedInPrice, Double parkingSpacePrice) {
		this.hasParkingSpace = hasParkingSpace;
		this.isParkingSpaceIncludedInPrice = isParkingSpaceIncludedInPrice;
		this.parkingSpacePrice = parkingSpacePrice;
	}
	/* Getters and Setters */
	public Boolean getHasParkingSpace() {
		return hasParkingSpace;
	}
	public void setHasParkingSpace(Boolean hasParkingSpace) {
		this.hasParkingSpace = hasParkingSpace;
	}
	public Boolean getIsParkingSpaceIncludedInPrice() {
		return isParkingSpaceIncludedInPrice;
	}
	public void setIsParkingSpaceIncludedInPrice(Boolean isParkingSpaceIncludedInPrice) {
		this.isParkingSpaceIncludedInPrice = isParkingSpaceIncludedInPrice;
	}
	public Double getParkingSpacePrice() {
		return parkingSpacePrice;
	}
	public void setParkingSpacePrice(Double parkingSpacePrice) {
		this.parkingSpacePrice = parkingSpacePrice;
	}
	
	
}
