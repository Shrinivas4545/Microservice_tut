package com.example.movieratingservice;

import java.util.List;

public class UserRating {
	private List<Rating> listRatings;

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
