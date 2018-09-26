package com.labs.msa.user.domain.model;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List; 

import org.springframework.stereotype.Repository; 

@Repository 
public class UserRepository { 

  private List<User> Users = new ArrayList<User>(); 

    public void addUser(User User) { 
      Users.add(User); 
    } 

   public List<User> getUsers() { 
      return Collections.unmodifiableList(Users); 
   } 
 }
