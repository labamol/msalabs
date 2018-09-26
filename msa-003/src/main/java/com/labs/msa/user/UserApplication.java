package com.labs.msa.user;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication 
//adding for service discovery 
@EnableDiscoveryClient
	public class UserApplication { 
		public static void main(String[] args) {
			SpringApplication.run(UserApplication.class, args); 
		} 
} 
