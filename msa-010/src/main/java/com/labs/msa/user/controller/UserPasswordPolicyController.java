package com.labs.msa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labs.msa.user.domain.UserPasswordPolicyService;

    @RestController 
    @RequestMapping("/userpasswordpolicy")
    public class UserPasswordPolicyController {
    	
    	@Autowired
        private UserPasswordPolicyService service;

         
        @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
        public boolean getPolicyConformance(@RequestBody String password) {
          return service.getPolicyConformance(password);
        } 
	
}

