package com.belajar.restapi.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.belajar.restapi.entity.Users;
import com.belajar.restapi.input.UserInput;
import com.belajar.restapi.output.MasterModel;
import com.belajar.restapi.output.UserOutput;
import com.belajar.restapi.repository.UsersRepository;

@Service
public class UsersManager extends ManagerImpl{

	@Autowired
	private UsersRepository usersRepository;
	
	public List<UserOutput> getUsers(Integer page, Integer size)
	{
		try 
		{
			List<Users> listUser = new ArrayList<Users>();
			Long totalCount = usersRepository.count();
			setTotalRow(totalCount.intValue());
			if(page != null && size != null && page > 0 && size > 0)
			{
				Pageable pageable =  PageRequest.of(page-1, size, Sort.by(Direction.ASC, "id"));
				listUser = usersRepository.findAll(pageable).toList();
			}
			else
			{
				listUser = usersRepository.findAll(Sort.by(Direction.ASC, "id"));
			}
			if(listUser != null && !listUser.isEmpty())
			{
				List<UserOutput> userOutput = new ArrayList<UserOutput>();
				for(Users user : listUser)
				{
					userOutput.add(new UserOutput(user));
				}
				setOK("Success");
				return userOutput;
			}
			else
			{
				setNoContent();
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setBadRequest(e.getMessage());
			return null;
		}
	}
	
	public UserOutput getUser(Integer id)
	{
		try 
		{
			Users user = usersRepository.getById(id);
			if(user != null)
			{
				UserOutput output = new UserOutput(user);
				setOK("Success");
				return output;
			}
			else
			{
				setNoContent();
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setBadRequest(e.getMessage());
			return null;
		}
	}
	
	
	public void addUser(UserInput viewmodel)
	{
		try 
		{
			Users user = new Users();
			user.setFirstName(viewmodel.getFirstName());
			user.setLastName(viewmodel.getLastName());
			user.setPhoneNumber(viewmodel.getPhoneNumber());
			user.setEmail(viewmodel.getEmail());
			usersRepository.save(user);
			setOK("Success");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setBadRequest(e.getMessage());
		}
	}
	
	public void deleteUser(Integer id)
	{
		try 
		{
			usersRepository.deleteById(id);
			setOK("Success");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setBadRequest(e.getMessage());
		}
	}
	
	public void updateUser(UserInput viewmodel, Integer id)
	{
		try 
		{
			Users user = usersRepository.getById(id);
			user.setFirstName(viewmodel.getFirstName());
			user.setLastName(viewmodel.getLastName());
			user.setPhoneNumber(viewmodel.getPhoneNumber());
			user.setEmail(viewmodel.getEmail());
			usersRepository.save(user);
			setOK("Success");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			setBadRequest(e.getMessage());
		}

	}
	
	
	
}
