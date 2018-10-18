package com.lunatech.demo.services.entity;

import java.io.Serializable;

public class TitleRatings implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tconst;
	private Double averageRating;
	private Integer numVotes;
	public String getTconst() {
		return tconst;
	}
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	public Integer getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(Integer numVotes) {
		this.numVotes = numVotes;
	}

}
