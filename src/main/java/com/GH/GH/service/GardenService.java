package com.GH.GH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GH.GH.repo.GardenRepo;
import com.GH.GH.entity.Garden;

@Service
public class GardenService {

    @Autowired
    GardenRepo gardenRepo;
    @Autowired
    UserService userService;

    public Garden saveGarden(Garden garden){
        return gardenRepo.save(garden);
    }

    public Garden getGardenById(Integer id){
        if(gardenRepo.findById(id).isPresent()){
            return gardenRepo.findById(id).get();
        }
        return null;
    }

    
}
