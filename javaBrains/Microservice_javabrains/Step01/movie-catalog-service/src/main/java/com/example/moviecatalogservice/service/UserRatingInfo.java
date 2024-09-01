package com.example.moviecatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.Rating;
import com.example.moviecatalogservice.UserRating;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {
	
	@Autowired 
	private RestTemplate restTemplate;
	
//	@HystrixCommand(fallbackMethod = "getFallBackUserRating")
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/"+userId, UserRating.class);
	}
	
	public UserRating getFallBackUserRating(String userId) {
		return new UserRating(List.of(new Rating("0", 0)));
	}
}
