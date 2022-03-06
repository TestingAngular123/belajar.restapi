package com.belajar.restapi.output;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorDetail {
	private int status;
	private String message;
	private String detailmessage;
	private int executiontime;
	private HttpStatus detailInfo;

}
