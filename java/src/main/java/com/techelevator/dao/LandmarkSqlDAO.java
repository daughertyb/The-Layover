package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Landmark;


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
	
	//coordinates?
	private Landmark mapRowToLandmark(SqlRowSet rs) {
		Landmark landmark = new Landmark();
        landmark.setName(rs.getString("name"));
        landmark.setAddress(rs.getString("address"));
        landmark.setVenueType(rs.getString("venuetype"));
        landmark.setLocation(rs.getString("location"));
        landmark.setOperatingDays(rs.getString("operatingdays"));
        landmark.setOpeningTime(rs.getString("openingtime"));
        landmark.setClosingTime(rs.getString("closingtime"));
        landmark.setDescription(rs.getString("description"));
        landmark.setRating(rs.getBoolean("rating"));
        return landmark;
    }


	@Override
	public Landmark findLandmarkByOperatingDays(String operatingDays) throws RuntimeException {
        for (Landmark landmark : this.allLandmarks()) {
            if( landmark.getOperatingDays().toLowerCase().equals(operatingDays.toLowerCase())) {
                return landmark;
            }
        }
        throw new RuntimeException("Sorry, no landmarks are available to visit during" + operatingDays + ".");
    }


	@Override
	public Landmark findLandmarkByOperatingHours(String openingTime, String closingTime) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Landmark findLandmarkByVenueType(String venueType) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Landmark findLandmarkByDistance(String location) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
