package com.tinyurl.app.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tinyurl.app.database.UrlDetails;
import com.tinyurl.app.database.tokens;
import com.tinyurl.app.model.Token;
import com.tinyurl.app.repository.TokenRepository;
import com.tinyurl.app.repository.UrlRepository;

@Service
public class TokensDAO {
	@Autowired
	private UrlRepository urlRepository;
	@Autowired
	private TokenRepository tokenRepository;
	
	private static ArrayList<tokens> tokens= new ArrayList<tokens>();
	private static ArrayList<Token> token= new ArrayList<Token>();
	
	
	public void setTokens(){
		
		//tokenRepository.count();
		// need to fetch this from database
		tokens.addAll(tokenRepository.findAll());

		token.add(new Token("http://tinyurl/"+tokens.get(0).getToken()));
		token.add(new Token("http://tinyurl/"+tokens.get(1).getToken()));
		token.add(new Token("http://tinyurl/"+tokens.get(2).getToken()));
		token.add(new Token("http://tinyurl/"+tokens.get(3).getToken()));
		token.add(new Token("http://tinyurl/"+tokens.get(4).getToken()));
		
	}
	
	public ArrayList<Token> getTokens() {
		return token;
	}
	
	public void addToken(String customToken) {
		
		// check if tokens is not already present
		
		
	}
	
public void writeToDB(String orgURL,String shortURL) {
		
		// check if tokens is not already present
		
	long count=urlRepository.count();
	urlRepository.save(new UrlDetails(orgURL,shortURL));
	}

public void deleteRecords(String shortURLs) {
	tokenRepository.deleteByToken(shortURLs.substring(15));
}
	
		

@Cacheable(cacheNames="urlCache",key="#url")
public String getActualURL(String url) {
	//urlRepository.findByShortURL(url);
	try
    {
        System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
        Thread.sleep(1000*5);
    } 
	catch (InterruptedException e) 
    {
        e.printStackTrace();
    }
	return urlRepository.findByShortURL(url).getOrgURL();
}

}
