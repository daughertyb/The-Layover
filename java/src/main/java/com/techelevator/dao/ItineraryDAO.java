package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import com.techelevator.model.User;

public interface ItineraryDAO {
	
	
	//needs to pass in user id to create Itinerary?
	public void createItinerary (Long userId, int landmarkid);
	
	//should only need to take in a landmark id to add?
	Itinerary addLandmarkToItinerary (Landmark id);

	public void deleteLandmarkToItinerary (long id);
	
	public void deleteSingleLandmarkToItinerary (long id, int landmarkId);
	
//	public void deleteLandmarkToItinerary (Landmark id);
	
	//may need to take in a different param
	Itinerary changeItineraryStartLocation (Landmark id);
	
	
}
