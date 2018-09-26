package com.labs.msa.user.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class UserPaswordPolicyServiceDelegate {

	@Autowired
    RestTemplate restTemplate;
     
    @HystrixCommand(fallbackMethod = "getPolicyConformance_Fallback")
    public boolean getPolicyConformance(String password) {
 
        String response = restTemplate.exchange("http://localhost:8098//{password}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, password).getBody();
 
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return true;
    }
     
    @SuppressWarnings("unused")
    private boolean getPolicyConformance_Fallback(String password) {
  
    	System.out.println("Fallback method ");
        return true;
    }
 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
