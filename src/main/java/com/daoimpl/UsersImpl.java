package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.UsersDao;
import com.entities.Admin;
import com.entities.GateCheck;
import com.entities.Login;
import com.entities.Project;
import com.entities.Users;
import com.entities.chats;


@Repository
@Transactional
public class UsersImpl implements UsersDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}

	public List<Users> list() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public boolean delete(Users users) {
		try{
			session.getCurrentSession().delete(users);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	public List<Users> validateUser(Login login) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Users> list = session.getCurrentSession().createQuery("From Users as u where u.username='"+login.getUsername()+"' and u.password='"+login.getPassword()+"'").list();
		return list;
		
	}
	public List<Admin> validateAdmin(Login login1) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Admin> list = session.getCurrentSession().createQuery("From Admin as a where a.username='"+login1.getUsername()+"' and a.password='"+login1.getPassword()+"'").list();
		return list;
		
	}

	/*public boolean validateAdmin(Login login1) {
		if (login1.getUsername().equals("yogi") && login1.getPassword().equals("yogi")) {
			return true;
		}else {
			return false;
		}
	}*/

	public boolean save(Users users) {
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}

	

	public boolean saveorUpdate(chats chat) {
		
		System.out.println("Dao"+chat.getSenderid());
		
		int min = 1;
		int max = 100000;
		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		if(chat.getMesid().equals("NA")){
			chat.setMesid(String.valueOf(random_int));
		}else {
			
		}
		session.getCurrentSession().save(chat);
		return true;
	
	}

	public boolean retrieve(Users user) {
		session.getCurrentSession().createQuery("from users");
		return false;
	}

	public List<chats> retrieve(chats chat) {
		//session.getCurrentSession().createQuery("from chats where (senderid='"+chat.getSenderid()+"' or receiverid='"+chat.getSenderid()+"') and (senderid = '"+chat.getReceiverid()+"' or receiverid='"+chat.getReceiverid()+"') order by messageid");
		return session.getCurrentSession().createQuery("from chats where (senderid='"+chat.getSenderid()+"' or receiverid='"+chat.getSenderid()+"') and (senderid = '"+chat.getReceiverid()+"' or receiverid='"+chat.getReceiverid()+"') order by messageid").list();

	}
	
	
	public boolean saveOrUpdate1(GateCheck gatecheck) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(gatecheck);
		return true;
	}

	public List<GateCheck> list1() {
		return session.getCurrentSession().createQuery("from GateCheck").list();
	}

	public boolean Update(GateCheck gatecheck) {
		String sql=" Update gatecheck  set reviewBy='"+gatecheck.getReviewBy()+"',reviewStatus='"+gatecheck.getReviewStatus()+"' where id="+gatecheck.getId()+"";
	  session.getCurrentSession().createSQLQuery(sql).executeUpdate();
	  return true;
	}
	
	public boolean Update1(GateCheck gatecheck) {
		String sql=" Update gatecheck  set approvedBy='"+gatecheck.getApprovedBy()+"',approvedStatus='"+gatecheck.getApprovedStatus()+"' where id="+gatecheck.getId()+"";
	  session.getCurrentSession().createSQLQuery(sql).executeUpdate();
	  return true;
	}

	public boolean Update2(GateCheck gatecheck) {
		String sql=" Update gatecheck  set savingDate='"+gatecheck.getSavingDate()+"',dateTime='"+gatecheck.getDateTime()+"',raisedDateTime='"+gatecheck.getRaisedDateTime()+"',reviewDateTime='"+gatecheck.getReviewDateTime()+"',approvedDateTime='"+gatecheck.getApprovedDateTime()+"' where id='"+gatecheck.getId()+"'";
		  session.getCurrentSession().createSQLQuery(sql).executeUpdate();
		  return true;
	}

	public boolean saveOrUpdate(Project project) {
		session.getCurrentSession().save(project);
		return true;
	}

	public List<Project> list2() {
		return session.getCurrentSession().createQuery("from Project").list();
	}

	@Override
	public boolean delete(Project project) {
		try{
			session.getCurrentSession().delete(project);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	
	}
	
	
	
}