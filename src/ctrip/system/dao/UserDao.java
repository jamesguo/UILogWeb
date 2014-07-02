package ctrip.system.dao;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import com.common.viewmodel.UserSearchFilter;

import ctrip.system.model.User;

@Component
public class UserDao extends BaseDao{
	
	 public boolean addUser(User user) {  
		 try{ 
			 getSqlMapClientTemplate().insert("insertUser", user);
			 return true; 
			 }catch(RuntimeException e){	
			e.printStackTrace();
			 return false; 
			 }	
	    } 

	 public User findUserByName(String name)
	 {
		 SqlMapClientTemplate ss = getSqlMapClientTemplate();
		 System.out.println(ss );
		  User bean = (User)getSqlMapClientTemplate().queryForObject("selectUserByName",name);
		  return bean;
	 }
	 
	 public User findUserById(int id)
	 {
		 SqlMapClientTemplate ss = getSqlMapClientTemplate();
		 System.out.println(ss );
		  User bean = (User)getSqlMapClientTemplate().queryForObject("selectUserById",id);
		  return bean;
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<User> getAllUser()
	 {
		 return (List<User>)getSqlMapClientTemplate().queryForList("selectAllUsers");
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<User> searchUser(UserSearchFilter filter) {
		return (List<User>) getSqlMapClientTemplate().queryForList(
				"searchUser", filter);
	}

	public int searchUserCount(UserSearchFilter filter) {
		return (Integer) getSqlMapClientTemplate().queryForObject("searchUserCount", filter);
	} 
	 
	 public  boolean updateUser(User user)
	 {
		 try {
			 getSqlMapClientTemplate().update("updateUser", user);
			 return true; 
		} catch (Exception e) {
			e.printStackTrace();
			 return false; 
		}
	 }
	 
	 public void delUser(int id)
	 {
		 getSqlMapClientTemplate().delete("deleteUser", id);
	 }
	 
	 public Integer getMantisUserId(String username)
	 {
		 return (Integer)getSqlMapClientTemplate().queryForObject("getMantisUserId", username);
	 }
	 
	 public Integer getMantisUserIdByRealName(String username)
	 {
		 return (Integer)getSqlMapClientTemplate().queryForObject("getMantisUserIdByRealName", username);
	 }
}
