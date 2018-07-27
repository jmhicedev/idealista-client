package com.higuera.apiidealista.filters.model;

public enum LocaleType {
	
	ES("es"), IT("it"), PT("pt"), EN("en"), CA("ca");
	
	
	private final String value;
	
	LocaleType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
