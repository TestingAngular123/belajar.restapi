package com.belajar.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class UsersController {

	@PostMapping(value = "/add/user")
	public ResponseEntity<?> addUser(@RequestBody String viewModel) {
	
		System.out.println(viewModel.toString());
		return new ResponseEntity<String>(viewModel.toString(),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/get/user")
	public ResponseEntity<String> getUser(@RequestParam(value="id") String id)
	{		
		System.out.println(id);
		return new ResponseEntity<String>(id,HttpStatus.OK);
	}
	
}
