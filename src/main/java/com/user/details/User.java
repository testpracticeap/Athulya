package com.user.details;

public class User {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	public User() {
		
	}
	public User(int id,String name,String email,String phone, String address) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.address=address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
}
