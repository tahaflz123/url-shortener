package com.url.service;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.url.dto.UrlResponse;
import com.url.entity.Url;
import com.url.repository.UrlRepository;

@Service
public class UrlService {

	@Autowired
	private UrlRepository urlRepository;
	
	public UrlResponse createUrl(Long userId, String url) {
		System.err.println(userId);
		Url newUrl = new Url();
		newUrl.setBaseUrl(url);
		String shortedUrl = this.createShortedUrl();
		newUrl.setUserId(userId);
		newUrl.setShortedUrl(shortedUrl);
		this.urlRepository.save(newUrl);
		String fullUrl = "http://localhost:8080/s/" + newUrl.getShortedUrl();
		return new UrlResponse(userId,fullUrl);
	}

	public List<Url> getUrls(Long userId) {
		return this.urlRepository.findAllByUserId(userId);
	}

	
	
	
	public String createShortedUrl() {
		String shortedUrl = null;
		while(true) {
			shortedUrl = UUID.randomUUID().toString();
			boolean exists = this.urlRepository.existsByShortedUrl(shortedUrl);
			if(exists) {
				shortedUrl = UUID.randomUUID().toString();
				continue;
			}else {
				break;
			}
		}
		
		return shortedUrl;
	}

	public Url getUrlDetails(Long userId, Long urlId) {
		return this.urlRepository.findByUserIdAndId(userId,urlId);
	}

	@Transactional
	public Boolean deleteUserUrl(Long userId, Long urlId) {
		this.urlRepository.deleteByUserIdAndId(userId,urlId);
		return true;
	}

	public ResponseEntity<Void> redirect(String shortened, HttpServletRequest request, HttpServletResponse response) {
		Url dbUrl = this.urlRepository.findByShortedUrl(shortened);
		boolean urlStart = dbUrl.getBaseUrl().startsWith("http");
		if(urlStart) {
			return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create(dbUrl.getBaseUrl())).build();
		}
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create("http://" + dbUrl.getBaseUrl())).build();
	}

	
	
}
