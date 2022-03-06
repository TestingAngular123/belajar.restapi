package com.belajar.restapi.input;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInput {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
}
