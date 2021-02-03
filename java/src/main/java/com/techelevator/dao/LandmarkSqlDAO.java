package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.techelevator.model.Landmark;

@Component
@PreAuthorize("isAuthenticated()")
public class LandmarkSqlDAO implements LandmarkDAO {

	private JdbcTemplate jdbcTemplate;

	public LandmarkSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<String> allCities() {
		String sql = "select location from landmark";
		List<String> citiesRaw = new ArrayList<String>();
		List<String> cities = new ArrayList<String>();

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {

			String city = results.getString("location");

			citiesRaw.add(city);
		}

		for (String c : citiesRaw) {

			if (!cities.contains(c)) {
				cities.add(c);
			}
		}

		return cities;
	}

	@Override
	public List<Landmark> allLandmarks() {
		String sql = "select * from landmark";
		List<Landmark> landmarks = new ArrayList<Landmark>();

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {

			long id = results.getLong("id");
			String name = results.getString("name");
			String description = results.getString("description");
			String img = results.getString("img");
			String operatingDays = results.getString("operatingdays");
			String openingTime = results.getString("openingtime");
			String closingTime = results.getString("closingtime");
			String venueType = results.getString("venuetype");
			String location = results.getString("location");
			String address = results.getString("address");
			int thumbsUp = results.getInt("thumbsup");
			int thumbsDown = results.getInt("thumbsdown");
			double latitude = results.getDouble("latitude");
			double longitude = results.getDouble("longitude");

			Landmark afterLandmark = new Landmark(id, name, description, img, operatingDays, openingTime, closingTime,
					venueType, location, address, thumbsUp, thumbsDown, latitude, longitude);
			landmarks.add(afterLandmark);
		}

		return landmarks;
	}

	@Override
	public List<Landmark> searchLandmarks(String day, String location, String venueType) {

		String sql = "select landmark.name, landmark.openingtime, landmark.closingtime from landmark inner join daysopen on landmark.id = daysopen.landmarkid where daysopen."
				+ day + "='open' AND location=? AND venuetype=?";
		List<Landmark> landmarks = new ArrayList<Landmark>();

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, location, venueType);

		while (results.next()) {

			String name = results.getString("name");
			String openingTime = results.getString("openingtime");
			String closingTime = results.getString("closingtime");

			Landmark afterLandmark = new Landmark(name, openingTime, closingTime);
			landmarks.add(afterLandmark);
		}

		return landmarks;
	}

	@Override
	public Landmark findLandmarkByName(String name) throws RuntimeException {
		for (Landmark landmark : this.allLandmarks()) {
			if (landmark.getName().toLowerCase().equals(name.toLowerCase())) {
				return landmark;
			}
		}
		throw new RuntimeException("Landmark " + name + " was not found.");
	}

	@Override
	public int findIdByLandmarkName(String name) {
		return jdbcTemplate.queryForObject("select id from landmark where name = ?", int.class, name);
	}

	// coordinates?
//	private Landmark mapRowToLandmark(SqlRowSet rs) {
//		Landmark landmark = new Landmark();
//        landmark.setName(rs.getString("name"));
//        landmark.setAddress(rs.getString("address"));
//        landmark.setVenueType(rs.getString("venuetype"));
//        landmark.setLocation(rs.getString("location"));
//        landmark.setOperatingDays(rs.getString("operatingdays"));
//        landmark.setOpeningTime(rs.getString("openingtime"));
//        landmark.setClosingTime(rs.getString("closingtime"));
//        landmark.setDescription(rs.getString("description"));
//        landmark.setRating(rs.getBoolean("rating"));
//        return landmark;
//    }

	@Override
	public Landmark findLandmarkByOperatingDays(String operatingDays) throws RuntimeException {
		for (Landmark landmark : this.allLandmarks()) {
			if (landmark.getOperatingDays().toLowerCase().equals(operatingDays.toLowerCase())) {
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
