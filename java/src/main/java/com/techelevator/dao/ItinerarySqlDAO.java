package com.techelevator.dao;

import java.sql.PreparedStatement;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import com.techelevator.model.User;


@Component
public class ItinerarySqlDAO implements ItineraryDAO {

	  	private JdbcTemplate jdbcTemplate;

	    public ItinerarySqlDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	
// adding Itinerary inside the table
	@Override
	public void createItinerary(Long userId, int landmarkid) {
		String sql = "insert into itinerary (userid, landmarkid) values (" + userId + " , " + landmarkid + ")";
		
		jdbcTemplate.update(sql);
		
		System.out.println("###############################################5");
	}	
		
// delete all Itineraries for a user
	@Override
	public void deleteLandmarkToItinerary(long id) {
		
		String sql = "delete from Itinerary where userid = ?";
		
		jdbcTemplate.update(sql, id);

	}
	
	@Override
	public void deleteSingleLandmarkToItinerary(long id, int landmarkId) {
		
		String sql = "delete from Itinerary where userid = ? and landmarkid = ?";	
		
		jdbcTemplate.update(sql, id, landmarkId );
		
	}
	
	
	
	
//	@Override
//	public void deleteLandmarkToItinerary(Landmark id) {
//		String sql = "delete from Itinerary where userid = ?";
//		
//		jdbcTemplate.update(sql, id);
//
//	}
	

	@Override
	public Itinerary changeItineraryStartLocation(Landmark id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Itinerary addLandmarkToItinerary(Landmark id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
