package com.GH.GH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.GH.GH.entity.Greens;
import com.GH.GH.service.GreensService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GreensRestController {

	@Autowired
	GreensService greensService;

	
	@RequestMapping(value="/createGreen", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createGreen(@RequestBody Greens greens) {
		
		try {
			greensService.saveGreens(greens);
			return new ResponseEntity<Object>(greens, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
}
