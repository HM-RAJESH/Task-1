package com.lunatech.demo.services.entity;

public class TitleEpisode {
	private Tconst tconst;
	private String parentTconst;
	private Integer seasonNumber;
	private Integer episodeNumber;
	
	public Tconst getTconst() {
		return tconst;
	}
	public void setTconst(Tconst tconst) {
		this.tconst = tconst;
	}
	public String getParentTconst() {
		return parentTconst;
	}
	public void setParentTconst(String parentTconst) {
		this.parentTconst = parentTconst;
	}
	public Integer getSeasonNumber() {
		return seasonNumber;
	}
	public void setSeasonNumber(Integer seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	public Integer getEpisodeNumber() {
		return episodeNumber;
	}
	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

}
