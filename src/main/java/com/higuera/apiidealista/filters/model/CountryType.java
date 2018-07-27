package com.higuera.apiidealista.filters.model;

public enum CountryType {
	
	ES("es"), 
	IT("it"), 
	PT("pt");
	
	
	private final String value;
	
	CountryType(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
