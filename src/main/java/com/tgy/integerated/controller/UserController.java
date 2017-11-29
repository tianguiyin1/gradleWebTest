package com.tgy.integerated.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgy.integerated.bean.User;
import com.tgy.integerated.mapper.UserMapper;
import com.tgy.integerated.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	
	@Resource
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest requet,Model model,String id){
		int userid = Integer.valueOf(id);
		User user = userMapper.findById(userid);
		
		model.addAttribute("user", user);
		model.addAttribute("contextPath", getContextPath(requet));
		System.out.println("----------------------------------查询用户-----------------------------------");
		return "showUser";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(HttpServletRequest requet,Model model){
		List<User> users = userMapper.findAll();
		return successMap("查询所有用户成功", users);
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest requet,Model model,String id){
		if(id == null || id.trim().isEmpty()){
			return errorMap("id不能为空", null);
		}
		int ret = userMapper.delete(Integer.valueOf(id));
		return successMap("删除成功，id为：" + id, null);
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Map<String,Object> updateUser(HttpServletRequest requet,Model model,User user){
		if(user == null || user.getId() == null || user.getId().toString().trim().isEmpty() || user.getAge() == null || user.getAge().toString().trim().isEmpty()){
			return errorMap("user id不能为空", null);
		}
		int ret = userMapper.update(user);
		return successMap("更新成功,姓名为:" + user.getName(), null);
	}
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public Map<String,Object> insertUser(HttpServletRequest requet,Model model,User user){
		if(user == null || user.getName() == null || user.getName().toString().trim().isEmpty() || user.getAge() == null || user.getAge().toString().trim().isEmpty()){
			return errorMap("user name,age不能为空", null);
		}
		user.setId(-1);
		userMapper.save(user);
		return successMap("插入成功，用户为：" + user,  user);
	}
	
	private String getContextPath(HttpServletRequest request){
		//http://blog.csdn.net/pengxuan/article/details/6604578
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String appContext = request.getContextPath();
		String basePath = scheme + "://"+serverName + ":"+ serverPort + appContext; 
		return basePath;
	}
	
	private Map<String, Object> successMap(String desc,Object data){
		Map<String,Object> retMap = new HashMap<>();
		retMap.put("status", "success");
		retMap.put("desc", desc);
		retMap.put("data", data);
		return retMap;
	}
	
	private Map<String, Object> errorMap(String desc,Object data){
		Map<String,Object> retMap = new HashMap<>();
		retMap.put("status", "failed");
		retMap.put("desc", desc);
		retMap.put("data", data);
		return retMap;
	}

}
