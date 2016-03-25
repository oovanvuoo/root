package com.app.connectDB.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	private int ID;
	private String Username;
	private String Password;
	private String Name;
	private char Status;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getUsername() {
		return this.Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return this.Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public char getStatus() {
		return this.Status;
	}
	public void setStatus(char status) {
		this.Status = status;
	}
	protected User(int iD, String username, String password, String name, char status) {
		ID = iD;
		Username = username;
		Password = password;
		Name = name;
		Status = status;
	}
	protected User() {
	}
}
