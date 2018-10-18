package com.lunatech.demo.services.entity;

import java.io.Serializable;

public class TopRatedMovie implements Serializable{

	private static final long serialVersionUID = 1L;

	private String titleName;
	private String[] genres;
	private Double averageRating;
	
	public TopRatedMovie() {}
	
	public TopRatedMovie(String titleName, String[] genres, Double averageRating) {
		this.titleName = titleName;
		this.genres = genres;
		this.averageRating = averageRating;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	
	

}
