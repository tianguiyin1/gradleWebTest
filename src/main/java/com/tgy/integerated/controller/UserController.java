package com.tgy.integerated.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgy.integerated.bean.User;
import com.tgy.integerated.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/showUser",method = RequestMethod.GET)
	public String showUser(HttpServletRequest requet,Model model){
		String id = requet.getParameter("id");
		int userid = Integer.valueOf(id);
		User user = userService.getUserById(userid);
		model.addAttribute("user", user);
		System.out.println("---------------------------------------------------------------------");
		return "showUser";
	}
	
	@RequestMapping(value = "/getUser",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getUserById(HttpServletRequest requet){
		String id = requet.getParameter("id");
		int userid = Integer.valueOf(id);
		User user = userService.getUserById(userid);
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("user", user);
		return retMap;
	}
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.GET)
	public String updateUser(HttpServletRequest requet,Model model){
		User user = new User(1,"田桂银1",32);
		userService.aupdateUser(user);
		System.out.println("---------------------------------------------------------------------");
		return "showUser";
	}

}
