package com.zjm.entity;



/**
 * 用户登录类
 * @author zjm
 *
 */
public class Users {
	private String user_name;//用户登录名
	private String user_pwd;//用户登录密码
	private Integer user_type;//用户是否被冻结
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String user_name, String user_pwd, Integer user_type) {
		super();
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_type = user_type;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public Integer getUser_type() {
		return user_type;
	}
	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}
	
}
