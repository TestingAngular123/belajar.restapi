package com.belajar.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.restapi.input.UserInput;
import com.belajar.restapi.manager.UsersManager;
import com.belajar.restapi.output.ErrorDetail;
import com.belajar.restapi.output.ListUserOutput;
import com.belajar.restapi.output.MasterModel;
import com.belajar.restapi.output.UserOutput;


@RestController
@CrossOrigin(origins = "*")
public class UsersController {

	@Autowired
	private UsersManager userManager;
	
	@PostMapping(value = "/welcome")
	public ResponseEntity<?> welcome() {

		return new ResponseEntity<String>("Welcome",HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/users")
	public ResponseEntity<?> getUsers(@RequestParam(value="page", required = false) Integer page, @RequestParam(value="size", required = false) Integer size)
	{		
		List<UserOutput> userOutput = userManager.getUsers(page, size);
		ErrorDetail info = userManager.getInfo();
		if(info.getDetailInfo() == HttpStatus.OK)
		{
			ListUserOutput output = new ListUserOutput(userOutput);
			output.setInfo(info);
			output.setTotalRows(userManager.getTotalRow());
			return new ResponseEntity<ListUserOutput>(output, HttpStatus.OK);
		}
		else
		{
			MasterModel output = new MasterModel();
			output.setInfo(info);
			return new ResponseEntity<MasterModel>(output, info.getDetailInfo());
		}
	}
	
	
	
	@GetMapping(value = "/get/user")
	public ResponseEntity<?> getUser(@RequestParam(value="id") Integer id)
	{		
		UserOutput userOutput = userManager.getUser(id);
		ErrorDetail info = userManager.getInfo();
		if(info.getDetailInfo() == HttpStatus.OK)
		{
			ListUserOutput output = new ListUserOutput(userOutput);
			output.setInfo(info);
			output.setTotalRows(1);
			return new ResponseEntity<ListUserOutput>(output, HttpStatus.OK);
		}
		else
		{
			MasterModel output = new MasterModel();
			output.setInfo(info);
			return new ResponseEntity<MasterModel>(output, info.getDetailInfo());
		}
	}
	
	
	@PostMapping(value = "/add/user")
	public ResponseEntity<MasterModel> addUser(@RequestBody UserInput viewModel) 
	{
		MasterModel output = new MasterModel();
		userManager.addUser(viewModel);
		ErrorDetail info = userManager.getInfo();
		output.setInfo(info);
		return new ResponseEntity<MasterModel>(output, info.getDetailInfo());
	}
	
	
	@DeleteMapping(value = "/delete/user/{id}")
	public ResponseEntity<MasterModel> deleteUser(@PathVariable(value="id") Integer id)
	{		
		MasterModel output = new MasterModel();
		userManager.deleteUser(id);
		ErrorDetail info = userManager.getInfo();
		output.setInfo(info);
		return new ResponseEntity<MasterModel>(output, info.getDetailInfo());
	}
	
	@PutMapping(value = "/update/user/{id}")
	public ResponseEntity<MasterModel> updateUser(@RequestBody UserInput viewModel, @PathVariable(value="id") Integer id)
	{		
		MasterModel output = new MasterModel();
		userManager.updateUser(viewModel, id);
		ErrorDetail info = userManager.getInfo();
		output.setInfo(info);
		return new ResponseEntity<MasterModel>(output, info.getDetailInfo());
	}
	
	
}
