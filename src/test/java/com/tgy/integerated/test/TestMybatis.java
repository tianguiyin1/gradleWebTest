package com.tgy.integerated.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tgy.integerated.bean.User;
import com.tgy.integerated.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMybatis {

	@Resource
	private UserService userService;
	
	@Test
	public void insert(){
		User user = new User(-1, "田桂银2", 37);
		boolean b = userService.insertUser(user);
		
		System.out.println("------------------------------------------测试插入输出开始-------------------------------------------------");
		System.out.println(b);
		System.out.println("------------------------------------------测试插入输出结束-------------------------------------------------");
	}
	
	@Test
	public void delete(){
		
		boolean b = userService.deleteUserById(19);
		
		System.out.println("------------------------------------------测试删除输出开始-------------------------------------------------");
		System.out.println(b);
		System.out.println("------------------------------------------测试删除输出结束-------------------------------------------------");
	}
	
	@Test
	public void update(){
		User user = new User(18, "田桂银", 34);
		boolean b = userService.updateUser(user);
		
		System.out.println("------------------------------------------测试更新输出开始-------------------------------------------------");
		System.out.println(b);
		System.out.println("------------------------------------------测试更新输出结束-------------------------------------------------");
	}
	
	@Test
	public void selectOne(){
		User user = userService.getUserById(1);
		
		System.out.println("------------------------------------------测试单个输出开始-------------------------------------------------");
		System.out.println(user);
		System.out.println("------------------------------------------测试单个输出结束-------------------------------------------------");
	}
	
	@Test
	public void selectAll(){
		List<User> users = userService.getAllUser();
		
		System.out.println("------------------------------------------测试输出开始-------------------------------------------------");
		System.out.println(users);
		System.out.println("------------------------------------------测试输出结束-------------------------------------------------");
	}
}
