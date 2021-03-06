package com.lunatech.demo.services.entity;

import java.io.Serializable;

public class TitleBasics implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String originalTitle;
	private Boolean isAdult;
	private String startYear;
	private String endYear;
	private Integer runtimeMinutes;
	private String[] genres;
	
	public String getTconst() {
		return tconst;
	}
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	public String getTitleType() {
		return titleType;
	}
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public Boolean getIsAdult() {
		return isAdult;
	}
	public void setIsAdult(Boolean isAdult) {
		this.isAdult = isAdult;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public Integer getRuntimeMinutes() {
		return runtimeMinutes;
	}
	public void setRuntimeMinutes(Integer runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
	}

}
