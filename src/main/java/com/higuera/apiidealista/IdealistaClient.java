package com.higuera.apiidealista;

import java.io.IOException;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.higuera.apiidealista.dto.AuthResponseDTO;
import com.higuera.apiidealista.dto.SearchResponseDTO;
import com.higuera.apiidealista.filters.GenericFilter;
import com.higuera.apiidealista.services.AuthServiceImpl;
import com.higuera.apiidealista.services.SearchServiceImpl;

public class IdealistaClient {

	private String apikey;
	private String secret;
	
	private AuthResponseDTO authCredentials = null;
	
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}


	private AuthServiceImpl authService;
	
	private SearchServiceImpl searchService;
	
	private RestTemplate restTemplate;
	
	public IdealistaClient(){
		this.restTemplate = new RestTemplate();
		this.authService = new AuthServiceImpl(this.restTemplate);
		this.searchService = new SearchServiceImpl(this.restTemplate);
	}
	
	
	public AuthResponseDTO authenticate() throws JsonParseException, JsonMappingException, IOException {
		this.authCredentials = authService.authenticate(this.apikey, this.secret);
		return this.authCredentials;
	}
	
	public SearchResponseDTO search(GenericFilter filter) throws Exception {
		waitamoment();
		if(this.authCredentials == null || this.authCredentials.isEmpty()) {
			authenticate();
		}
		filter.setAuthResponse(this.authCredentials);
		return searchService.search(filter);
	}
	
	/**
	 * Wait a moment to fulfill with the idealista condition 1req/sec
	 * */
	private void waitamoment() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
