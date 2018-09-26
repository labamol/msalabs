package com.labs.msa.user.domain;

import java.util.List;


public interface UserPasswordPolicyService { 

  public boolean getPolicyConformance(String password); 
}  

