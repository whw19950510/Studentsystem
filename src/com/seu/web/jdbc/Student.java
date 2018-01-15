package com.seu.web.jdbc;

public class Student {
	private String firstname;
	private String lastname;
	private int id;
	private String email;
	
	public Student(String firstname, String lastname, int id, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.email = email;
	}
	
	public Student(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//used for debugging information
	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", id=" + id + ", email=" + email + "]";
	}
	
	
}
