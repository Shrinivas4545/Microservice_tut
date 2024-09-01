package com.example.moviecatalogservice;

import java.util.List;

public class UserRating {
	private List<Rating> listRatings;

	public UserRating() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRating(List<Rating> listRatings) {
		this.listRatings = listRatings;
	}

	public List<Rating> getListRatings() {
		return listRatings;
	}

	public void setListRatings(List<Rating> listRatings) {
		this.listRatings = listRatings;
	}
	
	
}
