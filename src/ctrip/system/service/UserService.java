package ctrip.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.viewmodel.GridView;
import com.common.viewmodel.UserSearchFilter;

import ctrip.system.dao.UserDao;
import ctrip.system.model.User;

@Component
public class UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	public boolean addorUpdateUser(User user) {
		if (user.getId() == 0) {
			return userDao.addUser(user);
		} else {
			return userDao.updateUser(user);
		}
	}

	public User userLogin(User user) {
		return userDao.findUserByName(user.getUser_name());
	}

	public User userInfo(User user) {
		return userDao.findUserById(user.getId());
	}

	public GridView<User> searchUser(UserSearchFilter filter) {
		filter.setPageIndex(filter.getPageSize()*filter.getPageIndex());
		List<User> list = userDao.searchUser(filter);
		int count = userDao.searchUserCount(filter);
		GridView<User> gridView = new GridView<User>();
		gridView.setData(list);
		gridView.setTotal(count);
		return gridView;
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
	
	public void delUser(User user)
	{
		userDao.delUser(user.getId());
	}
	
	 public Integer getMantisUserId(String username)
	 {
		 return userDao.getMantisUserId(username);
	 }
}
