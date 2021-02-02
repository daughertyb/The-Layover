package com.techelevator.model;

import java.time.LocalDateTime;

public class Landmark {
	
	private long id;
	private String name;
	private String address;
	private String location;
	private double latitude;
	private double longitude;
	private String coordinates;
	private String description;
	private String venueType;
	private String images;
	private String openingTime; 
	private String closingTime; 
	private String operatingDays;
	private boolean rating;
	
	

	public Landmark(long id, String name, String description, String img, String operatingDays, String openingTime,
		String closingTime, String venueType, String location, String address, boolean rating,
		double latitude, double longitude) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.venueType = venueType;
		this.location = location;
		this.images = img;
		this.operatingDays = operatingDays;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.rating = rating;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}

	public boolean isRating() {
		return rating;
	}

	public void setRating(boolean rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	//need more logic within coordinates lat and long
	//possibly need toString
	public String getCoordinates() {
		return coordinates;
	}
	
//	public void setCoordinates(double latitude, double longitude) {
//		this.setLatitude(latitude);
//		this.setLongitude(longitude);
//	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getVenueType() {
		return venueType;
	}


	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	public String getOpeningTime() {
		return openingTime;
	}


	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}


	public String getClosingTime() {
		return closingTime;
	}


	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}


	public String getOperatingDays() {
		return operatingDays;
	}

	public void setOperatingDays(String operatingDays) {
		this.operatingDays = operatingDays;
	}

//	@Override
//	   public String toString() {
//	      return "Landmark{" +
//	              ", Name:'" + name + '\'' +
//	              ", Address:'" + address + 
//	              ", Description:" + description +
//	              ", Venue Type:" + venueType +
//	              ", Location:" + location +
//	              ", Days Open:" + operatingDays +
//	              ", Hours:" + openingTime + "-" + closingTime +
//	              ", Landmark Description:" + description +
//	              ", Landmark Venue Type:" + venueType +
//	              '}';
//	   }

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	

}
