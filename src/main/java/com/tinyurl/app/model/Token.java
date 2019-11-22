package com.tinyurl.app.model;

public class Token {
	private String TokenString;
	
	public Token(String randomToken){
		TokenString=randomToken;
	}
	
	public String getToken() {
		return TokenString;
	}

	public void setToken(String customToken) {
		
	}
}
