package com.tinyurl.app.TGS;

import java.util.ArrayList;
import java.util.List;

import com.tinyurl.app.DAO.TokensDAO;
import com.tinyurl.app.model.Token;


public class TokenGeneratorService implements Service{
	
	private static TokenGeneratorService tgs;
	static int count=1;
	private static ArrayList<Token> tkCache = new ArrayList<Token>();
	List<String> shortURLs =new ArrayList<String>();
	
	static TokensDAO dao;
	
	private TokenGeneratorService(){
		if(count==1)
			//refillCache();
		count++;
	}
	
	public static TokenGeneratorService getInstance() {
		if(tgs==null) {
			tgs=new TokenGeneratorService();
			
		}
		return tgs;
		
	}
	
	public String getToken() {
		if(tkCache.size()==0) {
			refillCache();
		}
		String newToken=tkCache.remove(0).getToken();
		/*shortURLs.add(newToken);
		if(shortURLs.size()>2)*/
			dao.deleteRecords(newToken);
		return newToken;
	}
	public String getTokens(TokensDAO dao1) {
		dao=dao1;
		return getToken();
	}
	
	
	
	public void checkTokenList() {
		if(tkCache.size()<2) {
			// make a DB call and get the List replenished
			refillCache();
		}
	}
	
	public void refillCache() {
		//TokensDAO dao = new TokensDAO();
		dao.setTokens();
		tkCache.addAll(dao.getTokens());
	} 
	
	

}
