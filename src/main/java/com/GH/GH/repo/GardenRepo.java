package com.GH.GH.repo;

import com.GH.GH.entity.Garden;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepo extends JpaRepository<Garden, Integer>{
    

    // //user should be able to recall all gardens in history
    // @Query(value="SELECT x FROM user x where x.garden = ?1")
    // public List<Garden> getAllGardensFromUser();

    // //user should be able to recall all greens in 'named' garden 
    // @Query(value="SELECT x FROM garden x where x.garden_greens = ?1")
    // public List<GardenGreens> getAllGardenGreens();
}