package com.techelevator.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ItineraryDAO;

import com.techelevator.dao.UserDAO;


import java.security.Principal;


@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ItineraryController {
	
	private UserDAO userDAO;
	
	@Autowired
	ItineraryDAO dao;
	
	
	@RequestMapping(path="/add-itinerary/{id}", method= RequestMethod.POST)
	public void createItinerary (@PathVariable int id, Principal principal) {  // @RequestBody Itinerary itinerary 
		
		long userId = userDAO.findIdByUsername(principal.getName());
		
		dao.createItinerary(userId, id);
		
	}
	
	
//	@RequestMapping (path = "/requestreject/{transId}", method = RequestMethod.POST)
//	public void requestReject (@PathVariable int transId , @RequestBody Transfer transfer) {
//		
//		transferSqlDAO.requestReject(transId);
//	}
	
//	   @ResponseStatus(HttpStatus.CREATED)
//	    @RequestMapping(value = "/register", method = RequestMethod.POST)
//	    public void register(@Valid @RequestBody RegisterUserDTO newUser) {
//	        try {
//	            User user = userDAO.findByUsername(newUser.getUsername());
//	            throw new UserAlreadyExistsException();
//	        } catch (UsernameNotFoundException e) {
//	            userDAO.create(newUser.getUsername(),newUser.getPassword(), newUser.getRole());
//	        }
//	    }
	


}
