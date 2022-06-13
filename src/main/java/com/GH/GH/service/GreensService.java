package com.GH.GH.service;

import java.util.List;

import com.GH.GH.entity.Greens;
import com.GH.GH.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreensService {

    @Autowired
    GreensRepo greensRepo;
    @Autowired
    UserService userService;

    public Greens saveGreens(Greens greens){
        greensRepo.save(greens);
        return greensRepo.save(greens);
    }

    public List<Greens> getAllGreens(){
        return greensRepo.findAll();
    }

    public Greens getGreensById(Integer id){
        if(greensRepo.findById(id).isPresent()){
            return greensRepo.findById(id).get();
        }
        return null;
    }

    
}
