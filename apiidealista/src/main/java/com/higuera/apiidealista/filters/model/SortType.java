package com.higuera.apiidealista.filters.model;

public enum SortType {
	
	ASC("asc"), DESC("desc");
	
	
	private final String value;
	
	SortType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
