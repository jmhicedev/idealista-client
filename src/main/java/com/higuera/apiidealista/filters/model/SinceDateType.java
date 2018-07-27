package com.higuera.apiidealista.filters.model;

public enum SinceDateType {

	LAST_WEEK("W", "last_week"),
	LAST_MONTH("M", "last month"),
	LAST_DAY("T", "last day (for rent except rooms)"),
	LAST_2_DAYS("Y", "last 2 days (sale and rooms)");
	
	
	
	private final String value;
	private final String message;
	
	SinceDateType(String value, String message){
		this.value = value;
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public String getMessage() {
		return message;
	}
}
