package com.example.movieinfoservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://imdb146.p.rapidapi.com/v1/title/?id=tt0087884"))
//				.header("X-RapidAPI-Key", "033a477252mshdea5a164a986d2dp1f6b0bjsnebf847ae2efd")
//				.header("X-RapidAPI-Host", "imdb146.p.rapidapi.com")
//				.method("GET", HttpRequest.BodyPublishers.noBody())
//				.build();
//		HttpResponse<String> response = null;
//		try {
//			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(response.body());
		 
		return new Movie(movieId, "TestName");
	}
}
