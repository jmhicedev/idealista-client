package com.higuera.apiidealista.dto;

import java.util.List;

import com.higuera.apiidealista.model.ElementList;

public class SearchResponseDTO {
	
	private Integer actualPage;
	private Integer itemsPerPage;
	private Integer lowerRangePosition;
	private Boolean paginable;
	private String[] summary;
	private Integer total;
	private Integer totalPages;
	private Integer upperRangePosition;
	private List<ElementList> elementList;
	
	
	/* Getters and Setters */
	public Integer getActualPage() {
		return actualPage;
	}
	public void setActualPage(Integer actualPage) {
		this.actualPage = actualPage;
	}
	public Integer getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public Integer getLowerRangePosition() {
		return lowerRangePosition;
	}
	public void setLowerRangePosition(Integer lowerRangePosition) {
		this.lowerRangePosition = lowerRangePosition;
	}
	public Boolean getPaginable() {
		return paginable;
	}
	public void setPaginable(Boolean paginable) {
		this.paginable = paginable;
	}
	public String[] getSummary() {
		return summary;
	}
	public void setSummary(String[] summary) {
		this.summary = summary;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getUpperRangePosition() {
		return upperRangePosition;
	}
	public void setUpperRangePosition(Integer upperRangePosition) {
		this.upperRangePosition = upperRangePosition;
	}
	public List<ElementList> getElementList() {
		return elementList;
	}
	public void setElementList(List<ElementList> elementList) {
		this.elementList = elementList;
	}
	
	
}
