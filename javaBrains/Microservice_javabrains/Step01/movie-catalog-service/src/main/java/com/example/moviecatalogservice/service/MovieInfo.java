package com.example.moviecatalogservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.CatalogItem;
import com.example.moviecatalogservice.Movie;
import com.example.moviecatalogservice.Rating;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	
	@Autowired 
	private RestTemplate restTemplate;

	
	private Logger logger = LoggerFactory.getLogger(MovieInfo.class);
	
//	@HystrixCommand(fallbackMethod = "getFallBackCatalogItem")
//	@Retry(name = "default", fallbackMethod = "getFallBackCatalogItem")
	@CircuitBreaker(name = "default", fallbackMethod = "getFallBackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		logger.info("MovieInfo executed...");
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), "Description", rating.getRating());
	}
	
	public CatalogItem getFallBackCatalogItem(Rating rating) {
		
		return new CatalogItem("Movie not found", "", 0);
	}
}

