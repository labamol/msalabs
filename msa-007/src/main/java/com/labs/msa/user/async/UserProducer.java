package com.labs.msa.user.async;

import java.util.Arrays; 
import java.util.List; 
import java.util.Properties; 
 
import org.apache.kafka.clients.producer.KafkaProducer; 
import org.apache.kafka.clients.producer.Producer; 
import org.apache.kafka.clients.producer.ProducerRecord; 
import org.apache.kafka.common.serialization.StringSerializer;

import com.labs.msa.user.domain.model.User; 

public class UserProducer {
	
 
	public static void main(String[] args) { 
	    Properties props = new Properties(); 
	    props.put("bootstrap.servers", "192.168.99.100:9092"); 
	    props.put("key.serializer", StringSerializer.class.getName()); 
	    props.put("value.serializer", StringSerializer.class.getName()); 
	    Producer<String, String> producer = new KafkaProducer<>(props); 
	     
	    List<User> users = Arrays.asList( 
	      new User(100, "dhfoqf", "74tr7gfg"), 
	      new User(101, "quigq6", "dg73fgr7"), 
		  new User(102, "iqndlk", "784h8f4h"),
	      new User(103, "ikfowf", "2e2ueh2r")
	      ); 
	 
	    for(User user : users) { 
	      System.out.println("Sending user [" + user.toString() + "]"); 
	      ProducerRecord<String, String> record = new ProducerRecord<>( 
	          "users",  user.toString()); 
	      producer.send(record); 
	    } 
	 
	    producer.close(); 
	  } 
	} 

