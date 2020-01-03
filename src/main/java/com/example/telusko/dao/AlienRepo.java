package com.example.telusko.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.telusko.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
 
}
