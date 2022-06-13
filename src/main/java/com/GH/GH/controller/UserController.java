// package com.GH.GH.controller;

// import com.GH.GH.entity.User;
// import com.GH.GH.service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.servlet.ModelAndView;

// @Controller
// public class UserController {
    
// @Autowired
// UserService userService;

// @GetMapping("/")
// public String index(Model model){
//     return "index";
// }

// @GetMapping("/signUp")
// public ModelAndView signUp (Model model){
// return new ModelAndView("signUp", "user", new User());
// }

// @PostMapping("/signUp")
// public ModelAndView saveUser(@ModelAttribute User user, Model model){
    
//     User signedUpUser = userService.saveUser(user);
    
//     return new ModelAndView("profile", "user", signedUpUser);

// }

// @GetMapping("/signIn")
// public ModelAndView signIn(Model model){

//     return new ModelAndView("signIn", "user", new User());
// }

// @PostMapping("/signIn")
// public String signInUser(@ModelAttribute User user, Model model){

//     User signedInUser = userService.signInUser(user.getEmail(), user.getPass());

//     if(signedInUser == null){
//         model.addAttribute("error", "Invalid Username/Password combo");
//         model.addAttribute("user", new User());
//         return "signIn";
//     }
//     return "profile";
// }
// // timestamp 1:50 @ 5/31 for login

// }