package com.GH.GH.controller;

import com.GH.GH.service.GreensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/greens")
public class GreensController {
    
@Autowired
GreensService greenService;

@GetMapping("/greens/{userId}")
public String displayGreensSignedIn(@PathVariable("userId") Integer userId, Model model){
    return "greens";
}



}