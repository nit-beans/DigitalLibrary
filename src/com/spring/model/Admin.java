package com.spring.model;

public class Admin {
	private int id;
	private String emailId;
    private String password;
    
    public Admin(){
    	
    }
    
	public Admin(int id, String emailId, String password) {
	
		this.id = id;
		this.emailId = emailId;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
