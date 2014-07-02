package ctrip.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.WebResponse;
import com.common.viewmodel.GridView;
import com.common.viewmodel.UserSearchFilter;

import ctrip.system.model.User;
import ctrip.system.service.UserService;

@Controller
@RequestMapping(value = "/system")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/userReg.do")
	 public WebResponse addorUpadateUser(User user,HttpServletRequest request,
				HttpServletResponse response) {  
		
		WebResponse webResponse = new WebResponse();
		try {
			if (userService.addorUpdateUser(user)) {
				webResponse.setSuccess(true);
				webResponse.setMsg("注册成功！");
			} else {
				webResponse.setSuccess(false);
				webResponse.setMsg("注册失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			webResponse.setSuccess(false);
			webResponse.setMsg("注册失败！");
		}
		return webResponse;
	 }
	
	@ResponseBody
	@RequestMapping(value = "/userLogin.do")
	 public WebResponse userLogin(User user,HttpServletRequest request,
				HttpServletResponse response) throws Exception {  
		
		WebResponse webResponse = new WebResponse();
		try {
			User u = userService.userLogin(user);
			String password =	u.getUser_pwd();
			if (user.getUser_pwd().equals(password))
			{
				webResponse.setSuccess(true);
				webResponse.setMsg("登录成功！");
				request.getSession().setAttribute("user", u);
			}
			else
			{
				webResponse.setSuccess(false);
				webResponse.setMsg("登录失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			webResponse.setSuccess(false);
			webResponse.setMsg("登录失败！");
		}
		return webResponse;
	 }

	@ResponseBody
	@RequestMapping(value = "/userInfo.do")
	 public User userInfo(User user,HttpServletRequest request,
				HttpServletResponse response) throws Exception {  
		return userService.userInfo(user);
	 }
	
	@ResponseBody
	@RequestMapping(value = "/searchUser.do")
	public GridView<User> getAllUser(UserSearchFilter filter,HttpServletRequest request,
			HttpServletResponse response)
	{
			GridView<User> list = userService.searchUser(filter);
		    return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delUser.do")
	public WebResponse delUser(User user,HttpServletRequest request,
			HttpServletResponse response)
	{
		userService.delUser(user);
		WebResponse webResponse = new WebResponse();
		webResponse.setSuccess(true);
		webResponse.setMsg("删除成功！");
		return webResponse;
	}
	
}
