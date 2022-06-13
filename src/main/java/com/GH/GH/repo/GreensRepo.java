package com.GH.GH.repo;
import com.GH.GH.entity.Greens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreensRepo extends JpaRepository<Greens, Integer>{
    

}
