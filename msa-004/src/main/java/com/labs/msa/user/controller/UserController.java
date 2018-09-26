package com.labs.msa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labs.msa.user.domain.UserService;
import com.labs.msa.user.domain.model.User; 

    @RestController 
    @RequestMapping("/user")
    public class UserController {
    	
    	@Autowired
        private UserService service;
   	
    	@RequestMapping(path="user", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
        public User create(@RequestBody User User) {
          return service.create(User);
        }
  
        @RequestMapping(path="user", method = RequestMethod.GET, produces = "application/json")
        public List<User> findAll() {
          return service.findAll();
        } 
	
}

