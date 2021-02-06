package com.techelevator.dao;

import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import com.techelevator.model.User;

public class ItinerarySqlDAO implements ItineraryDAO {
	
	boolean itineraryCreated = false;
	
    private JdbcTemplate jdbcTemplate;
	

	@Override
	public void createItinerary(Long userId, int landmarkid) {
		
		String sql = "insert into itinerary (userid, landmarkid) values (?, ?)";
		
		jdbcTemplate.update(sql, userId, landmarkid);
	}	
		
//	@Override
//	public Itinerary addLandmarkToItinerary(Landmark id) {
//		String sql = ""
//		return null;
//	}

	@Override
	public Itinerary deleteLandmarkToItinerary(Landmark id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Itinerary changeItineraryStartLocation(Landmark id) {
		// TODO Auto-generated method stub
		return null;
	}

}
