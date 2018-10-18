package com.lunatech.demo.services.entity;

public class TitleAkas {
	private String titleID;
	private Integer ordering;
	private String title;
	private String region;
	private String language;
	private String[] types;
	private String[] attributes;
	private Boolean isOriginalTitle;
	
	public String getTitleID() {
		return titleID;
	}
	public void setTitleID(String titleID) {
		this.titleID = titleID;
	}
	public Integer getOrdering() {
		return ordering;
	}
	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String[] getAttributes() {
		return attributes;
	}
	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
	public Boolean getIsOriginalTitle() {
		return isOriginalTitle;
	}
	public void setIsOriginalTitle(Boolean isOriginalTitle) {
		this.isOriginalTitle = isOriginalTitle;
	}
}
