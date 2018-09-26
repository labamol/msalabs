package com.labs.msa.user.domain;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import java.util.List;

        @Service 
        public class UserPasswordPolicyServiceImpl implements UserPasswordPolicyService { 
    
          public boolean getPolicyConformance(String password) { 
            if (password.length() < 6 ) {
            	return false; 
            } else {
            	return true;
            }
          } 
          
        }
