package com.tinyurl.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyurl.app.startBootApp;
import com.tinyurl.app.DAO.TokensDAO;


@RestController
public class TinyUrlController {
	
	@Autowired TokensDAO dao;
	@RequestMapping(value="/getShortURL",method=RequestMethod.POST,consumes ="application/json",produces = "application/json")
	//@RequestMapping(value="/")
	public Map<String,String> message(@RequestBody Map<String,Object> payload) {
		HashMap<String, String> map = new HashMap<String,String>();
		
		
		
		//Store the key-value in database
		String orgURL=payload.keySet().toString();
		String shortURL=startBootApp.TGS.getTokens(dao);
		
		
		//return the tiny URL
	    map.put(orgURL, shortURL);
	    dao.writeToDB(orgURL, shortURL);
	    return map;
		
	}
	
	@RequestMapping(value="/redirect")
	public String getLongURL(@RequestParam("url") String p) {
		return(dao.getActualURL(p));
	}

}
