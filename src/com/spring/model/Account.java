package com.spring.model;

public class Account {
	private int id;
	private String emailId;
	private int userId;
	private String BookName;
	private String Status;
	private String timestamp;

	public Account() {

	}

	public Account(int id, String emailId, int userId, String bookName, String status, String timestamp) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.userId = userId;
		BookName = bookName;
		Status = status;
		this.timestamp = timestamp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
