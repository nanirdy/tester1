package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.UsersDao;
import com.entities.Admin;
import com.entities.GateCheck;
import com.entities.Login;
import com.entities.Project;
import com.entities.Users;
import com.entities.chats;
import com.servicesapi.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersDao userDao;
	
	public boolean saveOrUpdate(Users users) {
		return userDao.saveOrUpdate(users);
	}

	public List<Users> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}

	public List<Users> validateUser(Login login) {
		return userDao.validateUser(login);
	}
	public List<Admin> validateAdmin(Login login1) {
		return userDao.validateAdmin(login1);
	}
	/*public boolean validateAdmin(Login login1) 
	{
		
		return userDao.validateAdmin(login1);
	}*/
   
	public boolean save(Users users) {
		return userDao.save(users);
	}

	

	public boolean saveOrUpdate(chats chat) {
		return userDao.saveorUpdate(chat);
	}

	public boolean retrieve(Users users) {
		
		return userDao.retrieve(users);
	}

	public List<chats> retrieve(chats chat) {
		
		return userDao.retrieve(chat);
	}

	public boolean saveOrUpdate1(GateCheck gatecheck) {
		return userDao.saveOrUpdate1(gatecheck);
	}

	public List<GateCheck> list1() {
		
		return  userDao.list1();
	}

	public boolean Update(GateCheck gatecheck) {
		return userDao.Update(gatecheck);
	}

	
	public boolean Update1(GateCheck gatecheck) {
		return userDao.Update1(gatecheck);
	}

	public boolean Update2(GateCheck gatecheck) {
		return userDao.Update2(gatecheck);
	}

	public boolean saveOrUpdate(Project project) {
		return userDao.saveOrUpdate(project);
	}

	public List<Project> list2() {
		
		return  userDao.list2();
	}

	@Override
	public boolean delete(Project project) {
		
		return userDao.delete(project);
	}
		 
}
