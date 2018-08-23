package com.higuera.apiidealista.filters;

import com.higuera.apiidealista.dto.AuthResponseDTO;

public abstract class AbstractFilter {

	private AuthResponseDTO authResponse;
	
	
	public String getAuthorization() {
		if(authResponse.getToken_type().isEmpty() || authResponse.getAccess_token().isEmpty()) {
			return null;
		}
		return this.authResponse.getToken_type() + " " + this.authResponse.getAccess_token();
	}
	
	public boolean validate() throws Exception {
		if(authResponse == null) {
			throw new Exception("Authorization information is required");
		} else {
			if(authResponse.getToken_type() == null) {
				throw new Exception("Token type is required");
			}
			if(authResponse.getAccess_token() == null) {
				throw new Exception("Access Token is required");
			}
		}
		return true;
	}
	
	public AbstractFilter() {
		
	}
	
	public AbstractFilter(AuthResponseDTO authResponse) {
		this.authResponse = authResponse;
	}

	/* Getters and Setters */
	public AuthResponseDTO getAuthResponse() {
		return authResponse;
	}

	public void setAuthResponse(AuthResponseDTO authResponse) {
		this.authResponse = authResponse;
	}
	
}
