package com.higuera.apiidealista.filters.model;

public enum OperationType {
	
	SALE("sale"), 
	RENT("rent");
	
	
	private final String value;
	
	OperationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
