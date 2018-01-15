package com.sp.javabrains.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class User {

	@Id
	private int userId;
	
	@Transient // ignore this userName field and it is not added in table 
	//or we can also make a variable as static
	private String userName;
	
	@Temporal (TemporalType.DATE) // to define as date or time or timestamp
	private Date date;
	
	@Lob
	// two types : Clob(charecter long object) and Blob (byte long object) for longtext
	private String description;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", date="
				+ date + ", description=" + description + "]";
	}
	
	
}
