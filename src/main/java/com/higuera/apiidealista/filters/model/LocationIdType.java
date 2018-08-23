package com.higuera.apiidealista.filters.model;

public enum LocationIdType {
	
	/* Values got from Idealista website */
	
	MADRID("0-EU-ES-28"),
	MADRID_NORTE("0-EU-ES-28-01"),
	MADRID_CENTRO("0-EU-ES-28-07"),
	MADRID_NOROESTE("0-EU-ES-28-02"),
	MADRID_CUENCAALBERCHEGUADARRAMA("0-EU-ES-28-03"),
	MADRID_SUR("0-EU-ES-28-04"),
	MADRID_CORREDORDELHENARES("0-EU-ES-28-06"),
	MADRID_CUENCATAJOTAJUÑA("0-EU-ES-28-05"),
	MADRID_NORTE_SANSE("0-EU-ES-28-01-003"),
	MADRID_NORTE_ALCOBENDAS("0-EU-ES-28-01-002");
	
	private String value;
	
	
	private LocationIdType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
