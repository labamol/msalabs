package com.labs.msa.user.async;


import java.util.Arrays; 
import java.util.Properties; 

import org.apache.kafka.clients.consumer.ConsumerRecord; 
import org.apache.kafka.clients.consumer.ConsumerRecords; 
import org.apache.kafka.clients.consumer.KafkaConsumer; 
import org.apache.kafka.common.serialization.StringDeserializer; 

import com.google.gson.Gson;
import com.labs.msa.user.domain.model.User;
import com.labs.msa.user.domain.model.UserRepository; 


	 
	public class UserConsumer implements Runnable { 
	   
	  private static final Gson GSON = new Gson(); 
	  private static final UserRepository REPO = new UserRepository(); 
	 
	  public void run() { 
	    Properties props = new Properties(); 
	    props.put("bootstrap.servers", "192.168.99.100:9092"); 
	    props.put("group.id", "userConsumer"); 
	    props.put("key.deserializer", StringDeserializer.class.getName()); 
	    props.put("value.deserializer", StringDeserializer.class.getName()); 
	 
	    try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) { 
	      consumer.subscribe(Arrays.asList("users")); 
	      while (true) { 
	        ConsumerRecords<String, String> records = consumer.poll(100); 
	        for (ConsumerRecord<String, String> record : records) { 
	          System.out.printf("offset = %d, key = %s, value = %s%n",  
	              record.offset(),  
	              record.key(),  
	              record.value()); 
	           
	          REPO.addUser(GSON.fromJson(record.value(), User.class)); 
	        } 
	      } 
	    } catch (Exception e) { 
	      System.err.println("Error while consuming users. Details: " + e.getMessage()); 
	    } 
	  } 
	} 
