package com.higuera.apiidealista.model;

import java.util.Locale;

public class Center {

	private double lattitude;
	private double longitude;
	

	public Center() {
		
	}
	
	public Center(double lattitude, double longitude) {
		this.lattitude = lattitude;
		this.longitude = longitude;
	}
	
	public String getCoordinates() {
		return String.format(Locale.ENGLISH, "%f,%f", this.getLattitude(), this.getLongitude());
	}
	
	@Override
	public String toString() {
		return String.format(Locale.ENGLISH, "Center [lattitude=%f, longitude=%f]", this.getLattitude(), this.getLongitude());
	}
	
	/* Getters and Setters */
	public double getLattitude() {
		return lattitude;
	}
	
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
