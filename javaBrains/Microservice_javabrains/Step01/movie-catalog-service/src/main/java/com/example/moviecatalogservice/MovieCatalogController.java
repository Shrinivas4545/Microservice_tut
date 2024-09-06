package com.example.moviecatalogservice;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.service.MovieInfo;
import com.example.moviecatalogservice.service.UserRatingInfo;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRatingInfo; 
	
	@GetMapping("/{userId}")
//	@HystrixCommand(fallbackMethod = "getFallBackCatalog")
//	@CircuitBreaker(name = "fallBackMain", fallbackMethod = "getFallBackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//get all rated movie ids
		UserRating ratings = userRatingInfo.getUserRating(userId);
		
		//for each movie id call movie info service and get details
		
		//put them all together
//		return ratings.getListRatings().stream().map( rating -> {
//					Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
//					return new CatalogItem(movie.getName(), "Description", rating.getRating());
//				})
//				.collect(Collectors.toList());
		
		return ratings.getListRatings().stream().map( rating -> movieInfo.getCatalogItem(rating))
		.collect(Collectors.toList());
				
		
//		return List.of(new CatalogItem("Transformers", "Test", 4));
	}
	
	public List<CatalogItem> getFallBackCatalog(Exception e){
		return List.of(new CatalogItem("No movie", "", 0));
	}
	
}
