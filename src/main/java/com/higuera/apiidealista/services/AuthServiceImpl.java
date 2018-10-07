package com.higuera.apiidealista.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.higuera.apiidealista.dto.ApiError;
import com.higuera.apiidealista.dto.AuthResponseDTO;

@Service
public class AuthServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	
    private RestTemplate restTemplate;
	
	
	public AuthServiceImpl(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}

	public AuthResponseDTO authenticate(final String apikey, final String secret) throws JsonParseException, JsonMappingException, IOException {
		
		String baseUrl = "https://api.idealista.com";
		String url = baseUrl + "/oauth/token";
		String authorization = "Basic "
				+ Base64.getEncoder().encodeToString(new String(apikey + ":" + secret).getBytes(StandardCharsets.UTF_8));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", authorization);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		map.add("scope", "read");
		HttpEntity<MultiValueMap<String, String>> requestEntity = 
	            new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		AuthResponseDTO authResponse = null;
		
		try {
			ResponseEntity<AuthResponseDTO> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, AuthResponseDTO.class);
			authResponse = responseEntity.getBody();
		} catch (HttpClientErrorException e) {
			ObjectMapper om = new ObjectMapper();
			logger.error(e.getStatusCode() + " " + e.getStatusText() + ": " + e.getMessage());
			String responseBody = e.getResponseBodyAsString();
			logger.error(responseBody);
			ApiError apierror = om.readValue(responseBody, ApiError.class);
			logger.error(apierror.getError() + ": " + apierror.getError_description());
			throw e;
		} catch (HttpServerErrorException e) {
			ObjectMapper om = new ObjectMapper();
			String responseBody = e.getResponseBodyAsString();
			ApiError apierror = om.readValue(responseBody, ApiError.class);
			logger.error(apierror.getError() + ": " + apierror.getError_description());
			throw e;
		}
		
		return authResponse;
	}
}
