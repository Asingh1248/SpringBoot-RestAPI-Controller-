package com.example.telusko.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.telusko.dao.AlienRepo;
import com.example.telusko.model.Alien;

@RestController
public class AlienController {
	
  @Autowired
  AlienRepo repo;
  
  @RequestMapping("/")
  public String home() {
	  
	  return "home.jsp";
  }
  
  

 //************REST API ****************
  
  @DeleteMapping(path="/alien/{aid}")
  public String deleteAlienRest(@PathVariable int aid)
  {
	  Alien a =repo.getOne(aid);
	  repo.delete(a);
	  return "deleted";
	  
  }
  
  @PutMapping(path="/alien",consumes= {"application/json"})
  public Alien saveOrUpdateAlien(@RequestBody Alien alien)
  {
	  repo.save(alien);
	  return alien;
  }
  
  
  @PostMapping(path="/alien",consumes= {"application/json"})
  public Alien addAlien(@RequestBody Alien alien)
  {
	  repo.save(alien);
	  return alien;
  }
  
  @GetMapping(path="/aliens")

  public List<Alien> getAliens()
  {
	  
	  return repo.findAll();
  }
  
  @RequestMapping("/alien/{aid}")

  public Optional<Alien> getAlien(@PathVariable("aid") int aid)
  {
	  
	  return repo.findById(aid);
  }
  //******************************************
  @RequestMapping("/deleteAlien")
  public ModelAndView deleteAlien(@RequestParam int aid)
  {
	  ModelAndView mv=new ModelAndView("deleteStatus.jsp");
	  Alien alien = repo.findById(aid).orElse(new Alien());
	  repo.delete(alien);
	  
	  return mv;
	  
  }
}
