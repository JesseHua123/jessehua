package com.etc.dao;

import java.util.List;

import com.etc.entity.Users;

public interface IUserDao {

	/**
	 * 添加用户
	 * @param username
	 * @param userpwd
	 * @return
	 */
	public boolean addUser(String username,String userpwd);
	
	/**
	 * 查询所有用户
	 */
	public List<Users> queryAllUser();
	
	/**
	 * 查询单个用户
	 * 根据用户编号
	 * @return
	 */
	 public Users queryUserById();
	 
	 /**
	  * 模糊查询
	  * 根据用户姓名
	  */
	 public List<Users> queryUserLikeNameByPage(int pageNo, int pageSize,String name);
	 
	 /**
	  * 分页查询
	  */
	 public List<Users> queryUserByPage();
	 
	 
}
