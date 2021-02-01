package com.techelevator.model;

import java.time.LocalDateTime;

public class Landmark {
	
	private Long id;
	private String name;
	private String address;
	private String description;
	private String venueType;
	private String location;
	private String images;
	private long openingTime; 
	private long closingTime; 
	private String operatingDays;
	private boolean rating;
	
	public Landmark() {}
	
	public Landmark(Long id, String name, String address, String description, String venueType, String location, String images,
			long openingTime, long closingTime, String operatingDays, boolean rating) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.venueType = venueType;
		this.location = location;
		this.images = images;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.operatingDays = operatingDays;
		
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


	public long getOpeningTime() {
		return openingTime;
	}


	public void setOpeningTime(long openingTime) {
		this.openingTime = openingTime;
	}


	public long getClosingTime() {
		return closingTime;
	}


	public void setClosingTime(long closingTime) {
		this.closingTime = closingTime;
	}


	public String getOperatingDays() {
		return operatingDays;
	}

	public void setOperatingDays(String operatingDays) {
		this.operatingDays = operatingDays;
	}

	@Override
	   public String toString() {
	      return "Landmark{" +
	              ", Name:'" + name + '\'' +
	              ", Address:'" + address + 
	              ", Description:" + description +
	              ", Venue Type:" + venueType +
	              ", Location:" + location +
	              ", Days Open:" + operatingDays +
	              ", Hours:" + openingTime + "-" + closingTime +
	              ", Landmark Description:" + description +
	              ", Landmark Venue Type:" + venueType +
	              '}';
	   }
	
	

}
