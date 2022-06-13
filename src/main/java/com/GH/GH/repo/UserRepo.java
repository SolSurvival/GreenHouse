package com.GH.GH.repo;

import com.GH.GH.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    
    @Query(value="select * from user where email = ?1 && pass = ?2", nativeQuery=true)
    public User findByTheEmailAndPassword(String email, String pass);

    @Query(value="select * from user where email = ?1", nativeQuery=true)
	public User findByEmail(String email);
}
