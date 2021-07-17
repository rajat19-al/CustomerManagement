package com.mycompany.dto;

public class CustomerDto {
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public CustomerDto() {
		
	}

	public CustomerDto(String firstName, String lastName, String emailAddress, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "CustomerDto [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress+ ", password=" + password+"]";
	}
	
	
	
}
