package com.daoapi;

import java.util.List;

import com.entities.Admin;
import com.entities.GateCheck;
import com.entities.Login;
import com.entities.Project;
import com.entities.Users;
import com.entities.chats;

public interface UsersDao {
	public boolean saveOrUpdate(Users users);
	public List<Users> list();
	public boolean delete(Users users);
	public List<Users> validateUser(Login login);
	public List<Admin> validateAdmin(Login login1);
	public boolean save(Users users);
	public boolean saveorUpdate(chats chat);
	public boolean retrieve(Users user);
	public List<chats> retrieve(chats chat);
	public boolean saveOrUpdate1(GateCheck getcheck);
	public List<GateCheck> list1();
	public boolean  Update(GateCheck gatecheck);
	public boolean  Update1(GateCheck gatecheck);
	public boolean  Update2(GateCheck gatecheck);
	public boolean saveOrUpdate(Project project);
	public List<Project> list2();
	public boolean delete(Project project);
}
