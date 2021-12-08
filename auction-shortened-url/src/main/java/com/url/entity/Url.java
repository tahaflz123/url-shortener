package com.url.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private Long userId;
	
	private String baseUrl;
	
	private String shortedUrl;
	
	
	public Url() {
	}


	public Url(Long userId, String baseUrl, String shortedUrl) {
		this.userId = userId;
		this.baseUrl = baseUrl;
		this.shortedUrl = shortedUrl;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getBaseUrl() {
		return baseUrl;
	}


	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}


	public String getShortedUrl() {
		return shortedUrl;
	}


	public void setShortedUrl(String shortedUrl) {
		this.shortedUrl = shortedUrl;
	}
	
	
	
	
	
	
}
