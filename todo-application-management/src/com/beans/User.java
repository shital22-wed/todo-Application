package com.beans;



public class User{
	
	public int id;
	public String firstName;
	public String lastName;
	public String gender;
	public String phone;
	public String username;
	public String password;
	public String rep_password;
	public String status;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRep_password() {
		return rep_password;
	}



	public void setRep_password(String rep_password) {
		this.rep_password = rep_password;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", phone=" + phone
				+ ", username=" + username + ", password=" + password + ", rep_password=" + rep_password + ", status="
				+ status + "]";
	}
	
	
	}
