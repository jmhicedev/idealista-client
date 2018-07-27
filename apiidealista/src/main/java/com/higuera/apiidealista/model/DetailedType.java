package com.higuera.apiidealista.model;

public class DetailedType {

	private String typology;
	private String subtypology;
	
	public DetailedType() {
		
	}
	
	public DetailedType(String typology, String subtypology) {
		this.typology = typology;
		this.subtypology = subtypology;
	}
	
	/* Getters and Setters */
	public String getTypology() {
		return typology;
	}
	public void setTypology(String typology) {
		this.typology = typology;
	}
	public String getSubtypology() {
		return subtypology;
	}
	public void setSubtypology(String subtypology) {
		this.subtypology = subtypology;
	}
	
	
}
