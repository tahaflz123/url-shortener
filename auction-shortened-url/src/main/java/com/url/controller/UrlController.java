package com.url.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.dto.UrlResponse;
import com.url.entity.Url;
import com.url.service.UrlService;


@RestController
public class UrlController {
	
	@Autowired
	private UrlService urlService;
	
	/*
	GET http://localhost:8080/user/{userId}/url/list
		GET http://localhost:8080/user/{userId}/url/detail/{urlId}
		DELETE http://localhost:8080/user/{userId}/url/detail/{urlId}*/
	
	@PostMapping("/user/{userId}/url/create")
	public UrlResponse createUrl(@PathVariable("userId") Long userId ,@PathParam("url") String url) {
		return this.urlService.createUrl(userId,url);
	}
	
	@GetMapping("/user/{userId}/url/list")
	public List<Url> getUserUrls(@PathVariable("userId")Long userId){
		return this.urlService.getUrls(userId);
	}
	
	@GetMapping("/user/{userId}/url/detail/{urlId}")
	public Url getUrlDetails(@PathVariable("userId")Long userId,@PathVariable("urlId") Long urlId) {
		return this.urlService.getUrlDetails(userId,urlId);
	}
	
	@DeleteMapping("/user/{userId}/url/detail/{urlId}")
	public Boolean deleteUserUrl(@PathVariable("userId")Long userId,@PathVariable("urlId") Long urlId) {
		return this.urlService.deleteUserUrl(userId,urlId);
	}
	
	@GetMapping("/s/{shortlink}")
	public ResponseEntity<Void> redirect(@PathVariable("shortlink") String shortened, HttpServletRequest request, HttpServletResponse response) {
		return this.urlService.redirect(shortened,request,response);
	}

}
