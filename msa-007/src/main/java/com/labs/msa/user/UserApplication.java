package com.labs.msa.user;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.labs.msa.user.async.UserConsumer; 

@SpringBootApplication 
	public class UserApplication { 
		public static void main(String[] args) {
			SpringApplication.run(UserApplication.class, args); 
			new Thread(new UserConsumer()).start();
		} 
} 
