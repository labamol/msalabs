package com.labs.msa.user.domain;

import java.util.List;

import com.labs.msa.user.domain.model.User; 

public interface UserService { 

  public User create(User User); 
  public List<User> findAll(); 
}  

