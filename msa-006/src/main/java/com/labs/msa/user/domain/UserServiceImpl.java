package com.labs.msa.user.domain;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import java.util.List;
import com.labs.msa.user.domain.model.User;
import com.labs.msa.user.domain.model.UserRepository; 
 
        @Service 
        public class UserServiceImpl implements UserService { 
   
          @Autowired 
          private UserRepository repository; 
 
          @Override 
          public User create(User User) { 
           repository.addUser(User); 
           return User; 
          } 
 
          @Override 
          public List<User> findAll() { 
            return repository.getUsers(); 
          } 
        }
