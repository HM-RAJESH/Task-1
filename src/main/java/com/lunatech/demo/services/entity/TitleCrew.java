package com.lunatech.demo.services.entity;

public class TitleCrew {
	private Tconst tconst;
	private Nconst[] directors;
	private Nconst[] writers;
	
	public Tconst getTconst() {
		return tconst;
	}
	public void setTconst(Tconst tconst) {
		this.tconst = tconst;
	}
	public Nconst[] getDirectors() {
		return directors;
	}
	public void setDirectors(Nconst[] directors) {
		this.directors = directors;
	}
	public Nconst[] getWriters() {
		return writers;
	}
	public void setWriters(Nconst[] writers) {
		this.writers = writers;
	}
	
	

}
