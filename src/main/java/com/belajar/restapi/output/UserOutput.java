package com.belajar.restapi.output;

import com.belajar.restapi.entity.Users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserOutput {
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	public UserOutput()
	{
		
	}
	
	public UserOutput(Users user)
	{
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.phoneNumber = user.getPhoneNumber();
		this.email = user.getEmail();
	}
}
