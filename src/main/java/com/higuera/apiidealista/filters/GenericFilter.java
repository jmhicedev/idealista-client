package com.higuera.apiidealista.filters;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.higuera.apiidealista.dto.AuthResponseDTO;
import com.higuera.apiidealista.filters.model.CountryType;
import com.higuera.apiidealista.filters.model.LocaleType;
import com.higuera.apiidealista.filters.model.OperationType;
import com.higuera.apiidealista.filters.model.OrderType;
import com.higuera.apiidealista.filters.model.PropertyTypeType;
import com.higuera.apiidealista.filters.model.SinceDateType;
import com.higuera.apiidealista.filters.model.SortType;
import com.higuera.apiidealista.model.Center;

public class GenericFilter extends AbstractFilter {
	
	public final static int MAX_MAXITEMS = 50;
	
	private CountryType country;
	private OperationType operation;
	private PropertyTypeType propertyType;
	private Center center;
	private LocaleType locale;
	private Double distance;
	private String locationId;
	private Integer maxItems;
	private Integer numPage;
	private Double maxPrice;
	private Double minPrice;
	private SinceDateType sinceDate;
	private OrderType order;
	private SortType sort;
	private Integer[] adIds;
	private Boolean hasMultimedia;
	
	
	/**
	 * Convert GenericFilter object in map to put into a http request
	 * */
	public MultiValueMap<String, String> getMap() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		if(this.country != null) 		map.add("country", this.getCountry().getValue());
		if(this.operation != null) 		map.add("operation", this.getOperation().getValue());
		if(this.propertyType != null) 	map.add("propertyType", this.getPropertyType().getValue());
		if(this.center != null) 		map.add("center", this.getCenter().getCoordinates());
		if(this.locale != null) 		map.add("locale", this.getLocale().getValue());
		if(this.distance != null) 		map.add("distance", this.getDistance().toString());
		if(this.locationId != null) 	map.add("locationId", this.getLocationId());
		if(this.maxItems != null) 		map.add("maxItems", this.getMaxItems().toString());
		if(this.numPage != null) 		map.add("numPage", this.getNumPage().toString());
		if(this.maxPrice != null) 		map.add("maxPrice", this.getMaxPrice().toString());
		if(this.sinceDate != null) 		map.add("sinceDate", this.getSinceDate().getValue());
		if(this.order != null) 			map.add("order", this.getOrder().getValue());
		if(this.sort != null) 			map.add("sort", this.getSort().getValue());
		if(this.adIds != null) {
			for(Integer id: adIds) {
				map.add("adIds", id.toString());
			}
		}
		if(this.hasMultimedia != null) 	map.add("hasMultimedia", this.getHasMultimedia().toString());
		
		return map;
	}
	
	public boolean validate() throws Exception {
		if(this.maxItems > GenericFilter.MAX_MAXITEMS) {
			throw new Exception("Max value for maxItems is " + GenericFilter.MAX_MAXITEMS);
		}
		
		return super.validate();
	}
	
	public GenericFilter(AuthResponseDTO authResponse) {
		super(authResponse);
	}
	
	
	/* Getters and Setters */
	public CountryType getCountry() {
		return country;
	}
	public void setCountry(CountryType country) {
		this.country = country;
	}
	public OperationType getOperation() {
		return operation;
	}
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}
	public PropertyTypeType getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(PropertyTypeType propertyType) {
		this.propertyType = propertyType;
	}
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	public LocaleType getLocale() {
		return locale;
	}
	public void setLocale(LocaleType locale) {
		this.locale = locale;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public Integer getMaxItems() {
		return maxItems;
	}
	public void setMaxItems(Integer maxItems) {
		this.maxItems = maxItems;
	}
	public Integer getNumPage() {
		return numPage;
	}
	public void setNumPage(Integer numPage) {
		this.numPage = numPage;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public SinceDateType getSinceDate() {
		return sinceDate;
	}
	public void setSinceDate(SinceDateType sinceDate) {
		this.sinceDate = sinceDate;
	}
	public OrderType getOrder() {
		return order;
	}
	public void setOrder(OrderType order) {
		this.order = order;
	}
	public SortType getSort() {
		return sort;
	}
	public void setSort(SortType sort) {
		this.sort = sort;
	}
	public Integer[] getAdIds() {
		return adIds;
	}
	public void setAdIds(Integer[] adIds) {
		this.adIds = adIds;
	}
	public Boolean getHasMultimedia() {
		return hasMultimedia;
	}
	public void setHasMultimedia(Boolean hasMultimedia) {
		this.hasMultimedia = hasMultimedia;
	}
	
	
}
