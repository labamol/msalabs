package com.labs.msa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.labs.msa.user.domain.UserService;
import com.labs.msa.user.domain.model.User; 

// Proxy controller we have to write for load balancing when using consul.
// To avoid this approach switch to using NGINX and Consul template

    @RestController 
    @RequestMapping("/user")
    public class UserLBController {
    	
    	@Autowired 
        private RestTemplate restTemplate;

    	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json") 
         public @ResponseBody String findAll() throws Exception { 
           return restTemplate.getForObject("http://user/user", String.class); 
          } 
    	    
	      @RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json", consumes = "application/json") 
	      public @ResponseBody String create(@RequestBody String body)throws Exception { 
	        HttpHeaders headers = new HttpHeaders(); 
	        headers.setContentType(MediaType.APPLICATION_JSON); 
	 
	        HttpEntity<String> entity = new HttpEntity<String>(body, headers); 
	 
	        return restTemplate.exchange("http://user/user", HttpMethod.POST, entity, String.class).getBody(); 
	      } 
    	
    	
    	
	
}

