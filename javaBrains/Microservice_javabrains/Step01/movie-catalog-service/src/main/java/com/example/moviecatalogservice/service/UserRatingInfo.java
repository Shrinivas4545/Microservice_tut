package com.example.moviecatalogservice.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.Rating;
import com.example.moviecatalogservice.UserRating;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class UserRatingInfo {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name="ratingFallBack", fallbackMethod = "getFallBackUserRating")
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/"+userId, UserRating.class);
	}
	
	public UserRating timeLimit(Exception e) {
		return new UserRating(List.of(new Rating("-2", -2)));
	}
	
	public UserRating getFallBackUserRating(Exception e) {
		return new UserRating(List.of(new Rating("-1", -1)));
	}
}
