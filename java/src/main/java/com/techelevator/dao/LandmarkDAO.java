package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Landmark;

public interface LandmarkDAO {
	
	List<Landmark> allLandmarks();
		
	Landmark findLandmarkByName (String name);
	
	Landmark findLandmarkByOperatingDays (String operatingDays);
	
	Landmark findLandmarkByOperatingHours (String openingTime, String closingTime);
	
	Landmark findLandmarkByVenueType (String venueType);
	
	// should possibly take in coordinates as well
	Landmark findLandmarkByDistance (String location);
	
	int findIdByLandmarkName (String name);
	
	

}
