package com.tgy.integerated.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tgy.integerated.bean.User;


public interface UserMapper {
	@Insert("insert into users (name,age) values (#{name},#{age})")
	void save(User user);
	
	@Update("update users set name = #{name},age = #{age} where id = #{id}")
	void update(User user);
	
	@Delete("delete from users where id = #{id}")
	void delete(int id);
	
	@Select("select * from users where id=#{id}")
	User findById(int id);
	
	@Select("select * from users ")
	List<User> findAll();

}
