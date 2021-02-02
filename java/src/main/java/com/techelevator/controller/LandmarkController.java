package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.LandmarkDAO;
import com.techelevator.model.Landmark;

@RestController
@PreAuthorize("isAuthenticated()")
public class LandmarkController {

	@Autowired
	LandmarkDAO dao;
	
	@RequestMapping(path="/get-all/landmarks", method= RequestMethod.GET)
	public List<Landmark> allLandmarks(){
		List<Landmark> listOfLandmarks = dao.allLandmarks();
		return listOfLandmarks;
	}
	
}
