package com.etc.entity;

public class Users {

	private int userid;
	private String username;
	private String userpwd;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public Users() {
		super();
	}
	public Users(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", userpwd=" + userpwd + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Users(int userid, String username, String userpwd) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
	}
	
	
}
