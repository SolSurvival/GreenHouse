package com.GH.GH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GH.GH.entity.GardenGreens;
import com.GH.GH.entity.Garden;
import com.GH.GH.entity.Greens;
import com.GH.GH.entity.User;
import com.GH.GH.service.GardenGreensService;
import com.GH.GH.service.GardenService;
import com.GH.GH.service.GreensService;
import com.GH.GH.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/garden")
public class GardenRestController {

	@Autowired
	GardenService gardenService;
	@Autowired
	UserService userService;
	@Autowired
	GreensService greensService;
	@Autowired
	GardenGreensService gardenGreensService;
	
	@GetMapping("/addGarden/{userId}")
	public String addNewGarden(@PathVariable Integer userId, @PathVariable Integer gardenId, Model model){

		User loggedInUser = userService.getUserById(userId);
		Garden garden = gardenService.getGardenById(gardenId);
		
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("garden", garden);
		return "addNewGarden";
	}

	@GetMapping("/addGreensToGarden/{userId}/{greensId}")
	public String addGreensToGardenComfirmation(@PathVariable Integer userId, 
			@PathVariable Integer greensId, Model model) {
		
		User loggedInUser = userService.getUserById(userId);
		Greens greens = greensService.getGreensById(greensId);
		
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("greens", greens);
		model.addAttribute("gardenItem", new GardenGreens());
		
		return "addToGarden";
	}
	
	@PostMapping("/addGreensToGarden/{userId}/{greensId}")
	public String addGreensToGarden(@PathVariable Integer userId, 
			@PathVariable Integer greensId, 
			@ModelAttribute GardenGreens gardenGreens,
			Model model) {
		
		User loggedInUser = userService.getUserById(userId);
		Greens greens = greensService.getGreensById(greensId);
		
	
		gardenGreensService.addGardenGreens(loggedInUser.getGarden().get(0), greens, gardenGreens);
		gardenGreensService.saveGardenGreens(gardenGreens);
		
		
		
		model.addAttribute("loggedInUser", loggedInUser);
		List<Greens> allGreens = greensService.getAllGreens();
		model.addAttribute("listOfProducts", allGreens);
		
		return "greens";
	}
	

}
