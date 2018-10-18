package com.lunatech.demo.services.entity;

public class NameBasics {
	private Nconst nconst;
	private String primaryName;
	private String birthYear;
	private String deathYear;
	private String[] primaryProfession;
	private Tconst[] knownForTitles;
	
	public Nconst getNconst() {
		return nconst;
	}
	public void setNconst(Nconst nconst) {
		this.nconst = nconst;
	}
	public String getPrimaryName() {
		return primaryName;
	}
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getDeathYear() {
		return deathYear;
	}
	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}
	public String[] getPrimaryProfession() {
		return primaryProfession;
	}
	public void setPrimaryProfession(String[] primaryProfession) {
		this.primaryProfession = primaryProfession;
	}
	public Tconst[] getKnownForTitles() {
		return knownForTitles;
	}
	public void setKnownForTitles(Tconst[] knownForTitles) {
		this.knownForTitles = knownForTitles;
	}
	

}
