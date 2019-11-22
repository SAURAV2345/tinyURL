package com.tinyurl.app.database;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TEST_DB")
public class UrlDetails{
	
	@Id
    @GeneratedValue
	private long id;
	
	
	
	private String orgURL;
	
	
	private String shortURL;
	
	UrlDetails(){
		super();
		}
	
	public UrlDetails(String orgURL,String shortURL){
		this.orgURL=orgURL;
		this.shortURL=shortURL;
	}

	public String getOrgURL() {
		return orgURL;
	}

	public void setOrgURL(String orgURL) {
		this.orgURL = orgURL;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	
	
	
	
}
