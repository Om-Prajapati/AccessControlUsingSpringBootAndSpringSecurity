package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
	UserRepository userRepository;

    @RequestMapping(value="/allUsers", method = RequestMethod.GET)
    public List<User> listUser(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User create(@RequestBody User user){
    	return userRepository.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
    	userRepository.deleteById(id);
        return "success";
    }

}
