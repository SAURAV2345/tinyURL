package com.tinyurl.app.TGS;

public class ServiceFactory {

	public TokenGeneratorService getInstance(String serviceName) {
		if(serviceName.equalsIgnoreCase("Token Generation Service"))
		return TokenGeneratorService.getInstance();
		return null;
	}
}
