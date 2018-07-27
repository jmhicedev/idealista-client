package com.higuera.apiidealista.filters.model;

public enum PropertyTypeType {
	
	HOMES("homes"),
	OFFICES("offices"),
	PREMISES("premises"),
	GARAGES("garages"),
	BEDROOMS("bedrooms");
	
	
	private final String value;
	
	PropertyTypeType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
}
