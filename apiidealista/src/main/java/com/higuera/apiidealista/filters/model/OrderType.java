package com.higuera.apiidealista.filters.model;

public enum OrderType {

	DISTANCE("distance"), 
	PRICE("price"), 
	STREET("street"), 
	PHOTOS("photos"), 
	PUBLICATION_DATE("publicationDate"), 
	MODIFICATION_DATE("modificationDate"), 
	WEIGH("weigh"), 
	PRICEDOWN("pricedown"), 
	SIZE("size"), 
	FLOOR("floor"), 
	RATIOEURM2("ratioeurm2"), 
	ROOMS("rooms");
	
	
	private final String value;
	
	OrderType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
