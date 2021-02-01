package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Landmark;

public interface LandmarkDAO {
	
	List<Landmark> allLandmarks();
	
	Landmark getLandmarkById(Long landmarkId);
	
	Landmark findLandmarkByName (String name);
	
	int findIdByLandmarkName (String name);
	
	

}
