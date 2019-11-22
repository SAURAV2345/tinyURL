package com.tinyurl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.tinyurl.app.TGS.ServiceFactory;
import com.tinyurl.app.TGS.TokenGeneratorService;

@SpringBootApplication
@EnableCaching
public class startBootApp {
	
	public static TokenGeneratorService TGS;
	
	public static void main(String[] args) {
		
		SpringApplication.run(startBootApp.class,args);
		startAllServices();
		
	}
	
	public static void startAllServices() {
		
		ServiceFactory sf = new ServiceFactory();
		TGS=sf.getInstance("Token Generation Service");
		
	}

}
