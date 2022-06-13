package com.GH.GH.repo;

import com.GH.GH.entity.GardenGreens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenGreensRepo extends JpaRepository<GardenGreens, Integer>{
    
    
}