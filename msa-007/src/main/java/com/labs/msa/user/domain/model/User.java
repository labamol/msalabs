package com.labs.msa.user.domain.model;

import java.io.Serializable;
import java.util.UUID;
import com.google.gson.*;

public class User implements Serializable {

	private static final long serialVersionUID = 1L; 
	private static final Gson GSON = new Gson(); 
	
	private long userId; 
	private String userName;
    private String loginPassword;
    
    public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	
	public User(long userId, String userName, String loginPassword) {
		this.userId = userId;
		this.userName = userName;
		this.loginPassword = loginPassword;
	}
	
	@Override 
	public String toString() { 
	  return GSON.toJson(this); 
	} 
    
}

