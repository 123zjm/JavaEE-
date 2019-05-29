package com.zjm.entity;

import java.io.Serializable;

/**
 * 用户注册类
 * @author zjm
 *
 */
public class User_info implements Serializable{
	
	private String info_nickname;//昵称
	private String info_phone;//用户电话
	private String info_email;//用户电子邮箱
	private Integer info_gender;//用户性别
	private String info_address;//用户地址
	private Integer user_id;//用户id
	public User_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_info(String info_nickname, String info_phone, String info_email, Integer info_gender,
			String info_address, Integer user_id) {
		super();
		this.info_nickname = info_nickname;
		this.info_phone = info_phone;
		this.info_email = info_email;
		this.info_gender = info_gender;
		this.info_address = info_address;
		this.user_id = user_id;
	}
	public String getInfo_nickname() {
		return info_nickname;
	}
	public void setInfo_nickname(String info_nickname) {
		this.info_nickname = info_nickname;
	}
	public String getInfo_phone() {
		return info_phone;
	}
	public void setInfo_phone(String info_phone) {
		this.info_phone = info_phone;
	}
	public String getInfo_email() {
		return info_email;
	}
	public void setInfo_email(String info_email) {
		this.info_email = info_email;
	}
	public Integer getInfo_gender() {
		return info_gender;
	}
	public void setInfo_gender(Integer info_gender) {
		this.info_gender = info_gender;
	}
	public String getInfo_address() {
		return info_address;
	}
	public void setInfo_address(String info_address) {
		this.info_address = info_address;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
}
