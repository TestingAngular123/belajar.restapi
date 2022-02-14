package com.belajar.restapi.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class RestHandler extends DefaultResponseErrorHandler{

	@Override
	protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
		System.out.println(response.getBody().toString());
//		super.handleError(response, statusCode);
	}


}
