package com.GH.GH.service;

import com.GH.GH.entity.User;
import com.GH.GH.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User getUserById(Integer id){
        if(userRepo.findById(id).isPresent()){
            User user = userRepo.findById(id).get();
        return user;       
     } 
     return null;
    }

    public User saveUser(User user){
        userRepo.save(user);

        return userRepo.save(user);
    }

    public User signInUser(String email, String pass){
        User user = userRepo.findByTheEmailAndPassword(email, pass);
        return user;
    }

    public void deleteUser(User user){
        userRepo.delete(user);
    }

    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public User getUserByEmailandPass(String email, String pass){
        return userRepo.findByTheEmailAndPassword(email, pass);
    }
}