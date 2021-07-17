package com.mycomany.model;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String Address;
	private String emailAddress;
	private String password;
	
	public Customer() {
		
	}
	
	public Customer(int id, String firstName, String lastName, int age, String address, String emailAddress, String password) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		Address = address;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", Address=" + Address
				+ ", emailAddress=" + emailAddress + ", password=" + password + ", id=" + id + " ]";
	}
	 
}
