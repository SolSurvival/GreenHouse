package com.GH.GH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GH.GH.entity.Garden;
import com.GH.GH.entity.GardenGreens;
import com.GH.GH.entity.Greens;
import com.GH.GH.repo.*;

@Service
public class GardenGreensService {

    @Autowired
    GardenGreensRepo gardenGreensRepo;
    @Autowired
    GreensRepo greensRepo;
    @Autowired
    GardenRepo gardenRepo;

    public GardenGreens saveGardenGreens(GardenGreens garden){
        return gardenGreensRepo.save(garden);
    }

    public void addGardenGreens(Garden garden, Greens greens, GardenGreens gardenGreens){
        greens.addGardenGreen(gardenGreens);
        garden.addGardenGreen(gardenGreens);
        gardenRepo.save(garden);
    }

    public GardenGreens getGardenGreensById(Integer id){
        if(gardenGreensRepo.findById(id).isPresent()){
            return gardenGreensRepo.findById(id).get();
        }
        return null;
    }
}