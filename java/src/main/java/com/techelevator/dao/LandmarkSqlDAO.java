package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.techelevator.model.Landmark;
import com.techelevator.model.User;

public class LandmarkSqlDAO implements LandmarkDAO {
	
	 private JdbcTemplate jdbcTemplate;

	   public LandmarkSqlDAO(JdbcTemplate jdbcTemplate) {
	       this.jdbcTemplate = jdbcTemplate;
	    }


	@Override
	public List<Landmark> allLandmarks() {
		List<Landmark> landmarks = new ArrayList<Landmark>();
		String sql = "select * from landmark";
		
	    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Landmark landmark = mapRowToLandmark(results);
            landmarks.add(landmark);
        }

        return landmarks;
	}

	@Override
	public Landmark getLandmarkById(Long landmarkId) {
		String sql = "SELECT * FROM landmark WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);
		if(results.next()) {
			return mapRowToLandmark(results);
		} else {
			throw new RuntimeException("Landmark ID "+landmarkId+" was not found.");
		}
	}

	@Override
	public Landmark findLandmarkByName(String name) throws RuntimeException {
        for (Landmark landmark : this.allLandmarks()) {
            if( landmark.getName().toLowerCase().equals(name.toLowerCase())) {
                return landmark;
            }
        }
        throw new RuntimeException("Landmark " + name + " was not found.");
    }

	@Override
	public int findIdByLandmarkName(String name) {
		 return jdbcTemplate.queryForObject("select id from landmark where name = ?", int.class, name);
	}
	
	private Landmark mapRowToLandmark(SqlRowSet rs) {
		Landmark landmark = new Landmark();
        landmark.setId(rs.getLong("id"));
        landmark.setName(rs.getString("name"));
        landmark.setAddress(rs.getString("address"));
        landmark.setVenueType(rs.getString("venuetype"));
        landmark.setLocation(rs.getString("location"));
        landmark.setOperatingDays(rs.getString("operatingdays"));
        landmark.setOpeningTime(rs.getLong("openingtime"));
        landmark.setClosingTime(rs.getLong("closingtime"));
        landmark.setDescription(rs.getString("description"));
        landmark.setRating(rs.getBoolean("rating"));
        return landmark;
    }
	
	

}
