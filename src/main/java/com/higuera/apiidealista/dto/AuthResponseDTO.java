package com.higuera.apiidealista.dto;

public class AuthResponseDTO {

	private String access_token;
	private String token_type;
	private Long expire_in;
	private String scope;
	

	public AuthResponseDTO() {
		//NOTHING TO DO
	}
	
	public AuthResponseDTO(String accessToken, String tokenType, Long expireIn, String scope) {
		this.access_token = accessToken;
		this.token_type = tokenType;
		this.expire_in = expireIn;
		this.scope = scope;
	}
	
	public String toString() {
		return this.getClass().getCanonicalName() + "[" 
				+ "accessToken: " + this.access_token 
				+ ", tokenType: " + this.token_type 
				+ ", expireIn: " + this.expire_in 
				+ ", scope: " + this.scope + 
			"]";
	}
	
	public boolean isEmpty() {
		if(this.access_token.isEmpty()) return true;
		if(this.token_type.isEmpty()) return true;
		return false;
	}

	
	/* Getters and Setters */
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Long getExpire_in() {
		return expire_in;
	}

	public void setExpire_in(Long expire_in) {
		this.expire_in = expire_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
