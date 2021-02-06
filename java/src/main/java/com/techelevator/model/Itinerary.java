package com.techelevator.model;

import java.time.LocalDate;

public class Itinerary {
	
	private String name;
	private String startPoint;
	private LocalDate date;
	private double latitude;
	private double longitude;
	
	
	
	public Itinerary(String name, String startPoint, LocalDate date) {
		this.name = name;
		this.startPoint = startPoint;
		this.date = date;
	}
	
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStartPoint() {
		startPoint = latitude + "," + longitude;
		return startPoint;
	}


	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
