package com.GH.GH.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.GH.GH.entity.User;
import com.GH.GH.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/user")
public class UserRestController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
public String index(Model model){
    return "index";
}

	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		
		try {
			userService.saveUser(user);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}


	@RequestMapping(value="/signIn", method=RequestMethod.GET)
public String signInUser(@ModelAttribute User user, Model model){

    User signedInUser = userService.signInUser(user.getEmail(), user.getPass());

    if(signedInUser == null){
        model.addAttribute("error", "Invalid Username/Password combo");
        model.addAttribute("user", new User());
        return "signIn";
    }
    return "profile";
}
	
	@RequestMapping(value="/findUserByEmail/{email}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		try {
			User loggedInUser = userService.getUserByEmail(email);
			
			if(loggedInUser == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	
}
