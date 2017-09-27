package com.etc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.IUserDao;
import com.etc.entity.Users;
/**
 * 业务层
 * @author Administrator
 * @Version
 */
@Service
public class UserService {
	
	@Autowired
	IUserDao dao;

	public boolean addUser(String username, String userpwd) {
	
		//调用dao层
		return dao.addUser(username, userpwd);	
	}


	public List<Users> queryAllUser() {
		
		return dao.queryAllUser();
	}
	
	
	public List<Users> queryLikeNameByPage(int pageNo, int pageSize,String name){
		return dao.queryUserLikeNameByPage(pageNo, pageSize, name);
	}
}
