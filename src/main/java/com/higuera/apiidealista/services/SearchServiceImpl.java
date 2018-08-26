package com.higuera.apiidealista.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.higuera.apiidealista.dto.ApiError;
import com.higuera.apiidealista.dto.SearchResponseDTO;
import com.higuera.apiidealista.filters.GenericFilter;

@Service
public class SearchServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	public SearchServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public SearchResponseDTO search(GenericFilter filter) throws Exception {
		
		String baseUrl = "https://api.idealista.com";
		String url = baseUrl + "/3.5/es/search";
		
		if(filter.getAuthorization() == null) {
			throw new Exception("You must specify apikey and token to security access");
		}
		
		if(filter.getLocationId() == null) {
			if(filter.getCenter() == null || filter.getDistance() == null) {
				throw new Exception("You must specify a center + distance or locationId in each request");
			}
		}
		
		if(filter.getPropertyType() == null) {
			throw new Exception("PropertyType required");
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", filter.getAuthorization());
		HttpEntity<MultiValueMap<String, String>> requestEntity = 
	            new HttpEntity<MultiValueMap<String, String>>(filter.getMap(), headers);
		
		SearchResponseDTO searchResponse = null;
		
		try {
			ResponseEntity<SearchResponseDTO> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, SearchResponseDTO.class);
			searchResponse = responseEntity.getBody();
		} catch (HttpClientErrorException e) {
			logger.error("HttpStatus: " + e.getLocalizedMessage());
			try {
				ObjectMapper om = new ObjectMapper();
				String responseBody = e.getResponseBodyAsString();
				ApiError apierror = om.readValue(responseBody, ApiError.class);
				logger.error(apierror.getHttpStatus() + ": " + apierror.getMessage());
			} catch (Exception e1) {
				logger.error("There is no object ApiError in the error response");
			} finally {
				e.printStackTrace();
			}
			throw e;
		} catch (HttpServerErrorException e) {
			logger.error("HttpStatus: " + e.getLocalizedMessage());
			ObjectMapper om = new ObjectMapper();
			String responseBody = e.getResponseBodyAsString();
			ApiError apierror = om.readValue(responseBody, ApiError.class);
			logger.error(apierror.getError() + ": " + apierror.getError_description());
			throw e;
		}
		
		return searchResponse;
	}
}
