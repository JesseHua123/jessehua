package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etc.entity.Users;
import com.etc.utils.DBUtil;
/**
 * 数据库访问层
 * @author Administrator
 * @Version
 */
@Repository
public class UserDao implements IUserDao{

	//调用数据库工具类
	@Autowired
	DBUtil dbUtil;
	

	public boolean addUser(String username, String userpwd) {
		
		String sql = "insert into tbl_users values(null,?,?)";
		
		int n = dbUtil.execUpdate(sql, username,userpwd);
			
		return n>0;
	}


	public List<Users> queryAllUser() {
		
		String sql =  "SELECT * from tbl_users";
		
		CachedRowSet crs = dbUtil.execQuery(sql);
		
		List<Users> list = new ArrayList<>();
		Users u = null;
		
		try {
			while (crs.next()) {
				int userid = crs.getInt(1);
				String username = crs.getString(2);
				String userpwd = crs.getString(3);
				
				u = new Users(userid,username, userpwd);
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}

	@Override
	public Users queryUserById() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 名字分页模糊查询
	 */
	@Override
	public List<Users> queryUserLikeNameByPage(int pageNo, int pageSize,String name) {
		String sql = "select * from tbl_users  where username LIKE  ? LIMIT ?,?";
		CachedRowSet crs = dbUtil.execQuery(sql,"%"+name+"%",(pageNo-1)*pageSize,pageSize);
		List<Users> list = new ArrayList<>();
		Users u = null;
		
		try {
			while (crs.next()) {
				int userid = crs.getInt(1);
				String username = crs.getString(2);
				String userpwd = crs.getString(3);
				
				u = new Users(userid,username, userpwd);
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
		
		
		
	}

	@Override
	public List<Users> queryUserByPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
